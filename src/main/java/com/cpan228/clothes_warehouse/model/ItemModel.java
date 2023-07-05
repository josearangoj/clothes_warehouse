package com.cpan228.clothes_warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@Table
//@Entity
public class ItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private FashionBrand brand;

    @Min(value = 2021, message = "Year must be at least 2021")
    private int yearOfCreation;

    @Min(value = 1001, message = "Price must be higher than 1000")
    private double price;

    @NotNull
    private LocalDateTime createdAt = LocalDateTime.now();

    public ItemModel() {
        this.createdAt = LocalDateTime.now();
    }

    public ItemModel(Long id, FashionBrand brand, int yearOfCreation, double price, LocalDateTime createdAt) {
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
