package com.cpan228.clothes_warehouse.model.dto;

import com.cpan228.clothes_warehouse.model.ItemModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistributionCentre {
    private int id;
    private String name;
    private int longitude;
    private int latitude;
    private List<ItemModel> item;
}
