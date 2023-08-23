package com.cpan228.clothes_warehouse.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@Table
public class ItemModel {

    @Id
    private Long id;

    private FashionBrand brand;

    @Min(value = 2021, message = "Year must be at least 2021")
    private int yearOfCreation;

    @Min(value = 1001, message = "Price must be higher than 1000")
    private double price;

    @NotNull
    private String createdAt = "2023-08-23 12:57:00.0";
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//    String now = LocalDateTime.now().format(formatter);

    public ItemModel() {
//        this.createdAt = now;
    }

    public ItemModel(Long id, FashionBrand brand, int yearOfCreation, double price, String createdAt) {
        this.id = id;
        this.brand = brand;
        this.yearOfCreation = yearOfCreation;
        this.price = price;
        this.createdAt = createdAt;
    }

    public enum FashionBrand {
        BALENCIAGA("Balenciaga"), STONE_ISLAND("Stone Island"), DIOR("Dior"), GUCCI("Gucci"), VERSACE("Versace"), LOUIS_VUITTON("Louis Vuitton");

        private String brandName;

        private FashionBrand(String brandName) {
            this.brandName = brandName;
        }

        public String getBrandName() {
            return brandName;
        }

    }
}
