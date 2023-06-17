package com.cpan228.clothes_warehouse.repository.impl;

import com.cpan228.clothes_warehouse.model.ItemModel;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRowMapper implements RowMapper<ItemModel> {

    @Override
    public ItemModel mapRow(ResultSet rs, int row) throws SQLException{
        return ItemModel.builder()
                .id(rs.getLong("id"))
                .brand(ItemModel.FashionBrand.valueOf(rs.getString("brand")))
                .yearOfCreation(rs.getInt("yearofcreation"))
                .price(rs.getDouble("price"))
                .build();
    }
}
