package com.cpan228.clothes_warehouse.repository;

import com.cpan228.clothes_warehouse.model.ItemModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<ItemModel, Long> {
    List<ItemModel> findByBrand(String brand);

    List<ItemModel> findByBrandAndYearOfCreation(String brand, int year);

}
