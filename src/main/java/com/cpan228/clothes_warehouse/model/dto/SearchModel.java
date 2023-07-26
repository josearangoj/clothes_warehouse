package com.cpan228.clothes_warehouse.model.dto;

import com.cpan228.clothes_warehouse.model.ItemModel;
import lombok.*;

@Data
@NoArgsConstructor
public class SearchModel {
    private ItemModel.FashionBrand brand;
    private String yearOfCreation;
}
