package com.cpan228.clothes_warehouse.repository;

import com.cpan228.clothes_warehouse.model.ItemModel;
import java.util.Optional;

public interface ItemRepository {
    Iterable<ItemModel> findAll();
    Optional<ItemModel> findById(Long id);
    void save(ItemModel itemModel);
}
