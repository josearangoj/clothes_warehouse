package com.cpan228.clothes_warehouse.repository;

import com.cpan228.clothes_warehouse.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
