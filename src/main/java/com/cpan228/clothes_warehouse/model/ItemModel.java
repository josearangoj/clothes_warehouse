package com.cpan228.clothes_warehouse.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class ItemModel {

    @Id
    private Long id;

    private FashionBrand brand;

    @Min(value = 2021, message = "Year must be at least 2021")
    private int yearOfCreation;

    @Min(value = 1001, message = "Price must be higher than 1000")
    private double price;
    public ItemModel() {
    }

    public ItemModel(Long id, FashionBrand brand, int yearOfCreation, double price) {
        this.id = id;
        this.brand = brand;
        this.yearOfCreation = yearOfCreation;
        this.price = price;
    }

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

    public static class ItemModelBuilder {
        private Long id;
        private FashionBrand brand;
        private @Min(value = 2021, message = "Year must be at least 2021") int yearOfCreation;
        private @Min(value = 1001, message = "Price must be higher than 1000") double price;

        ItemModelBuilder() {
        }

        public ItemModelBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ItemModelBuilder brand(FashionBrand brand) {
            this.brand = brand;
            return this;
        }

        public ItemModelBuilder yearOfCreation(@Min(value = 2021, message = "Year must be at least 2021") int yearOfCreation) {
            this.yearOfCreation = yearOfCreation;
            return this;
        }

        public ItemModelBuilder price(@Min(value = 1001, message = "Price must be higher than 1000") double price) {
            this.price = price;
            return this;
        }

        public ItemModel build() {
            return new ItemModel(this.id, this.brand, this.yearOfCreation, this.price);
        }

        public String toString() {
            return "ItemModel.ItemModelBuilder(id=" + this.id + ", brand=" + this.brand + ", yearOfCreation=" + this.yearOfCreation + ", price=" + this.price + ")";
        }
    }
}
