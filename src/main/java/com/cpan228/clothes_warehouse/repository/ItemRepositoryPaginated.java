package com.cpan228.clothes_warehouse.repository;

import com.cpan228.clothes_warehouse.model.ItemModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepositoryPaginated extends PagingAndSortingRepository<ItemModel, Long> {
}
