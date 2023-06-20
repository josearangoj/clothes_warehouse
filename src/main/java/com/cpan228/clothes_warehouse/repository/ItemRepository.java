package com.cpan228.clothes_warehouse.repository;

import com.cpan228.clothes_warehouse.model.ItemModel;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<ItemModel, Long> {
}
