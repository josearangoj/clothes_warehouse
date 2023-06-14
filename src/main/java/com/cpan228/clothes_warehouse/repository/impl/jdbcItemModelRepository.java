package com.cpan228.clothes_warehouse.repository.impl;

import com.cpan228.clothes_warehouse.model.ItemModel;
import com.cpan228.clothes_warehouse.repository.ItemRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class jdbcItemModelRepository implements ItemRepository {
    private JdbcTemplate jdbcTemplate;

    public jdbcItemModelRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<ItemModel> findAll(){
        return jdbcTemplate.query("SELECT * FROM items", new ItemRowMapper());
    }

    @Override
    public Optional<ItemModel> findById(Long id){
        ItemModel item = jdbcTemplate.queryForObject("SELECT * FROM items WHERE id = ?", new ItemRowMapper(), id);
        return Optional.ofNullable(item);
    }

    @Override
    public void save(ItemModel itemModel){
        var insertItem = "INSERT INTO items (brand, year_created, price) VALUES (?, ?, ?)";
        var keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            var ps = connection.prepareStatement(insertItem);
            ps.setString(1, itemModel.getBrand().name());
            ps.setInt(2, itemModel.getYearOfCreation());
            ps.setDouble(3, itemModel.getPrice());
            return ps;
        }, keyHolder);
    }

}
