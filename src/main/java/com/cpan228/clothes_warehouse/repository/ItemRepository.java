package com.cpan228.clothes_warehouse.repository;

import com.cpan228.clothes_warehouse.model.ItemModel;
import com.cpan228.clothes_warehouse.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<ItemModel, Long> {
    List<ItemModel> findByBrand(String brand);

    List<ItemModel> findByBrandAndYearOfCreation(String brand, int yearOfCreation);
}
