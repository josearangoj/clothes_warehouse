package com.cpan228.clothes_warehouse.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
//@Data
@Builder
public class ItemModel {

    private Long id;

    private FashionBrand brand;

    @Min(value = 2021, message = "Year must be at least 2021")
    private int yearOfCreation;

    @Min(value = 1001, message = "Price must be higher than 1000")
    private double price;

    public FashionBrand getBrand() {
        return brand;
    }

    public void setBrand(FashionBrand brand) {
        this.brand = brand;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public enum FashionBrand {
        BALENCIAGA("Balenciaga"),
        STONE_ISLAND("Stone Island"),
        DIOR("Dior"),
        GUCCI("Gucci"),
        VERSACE("Versace"),
        LOUIS_VUITTON("Louis Vuitton");

        private String brandName;

        private FashionBrand(String brandName) {
            this.brandName = brandName;
        }

        public String getBrandName() {
            return brandName;
        }

    }
}
