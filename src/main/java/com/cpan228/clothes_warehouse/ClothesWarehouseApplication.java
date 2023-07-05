package com.cpan228.clothes_warehouse;

import com.cpan228.clothes_warehouse.model.ItemModel;
import com.cpan228.clothes_warehouse.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;

@SpringBootApplication
public class ClothesWarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClothesWarehouseApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(ItemRepository repository){
		return args -> {
			LocalDateTime now = LocalDateTime.now();

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.GUCCI)
					.yearOfCreation(2023)
					.price(1250.5)
					.createdAt(now)
					.build());

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.BALENCIAGA)
					.yearOfCreation(2022)
					.price(1899.5)
					.createdAt(now)
					.build());

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.DIOR)
					.yearOfCreation(2022)
					.price(1330.5)
					.createdAt(now)
					.build());

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.LOUIS_VUITTON)
					.yearOfCreation(2023)
					.price(1765)
					.createdAt(now)
					.build());

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.LOUIS_VUITTON)
					.yearOfCreation(2023)
					.price(1599.99)
					.createdAt(now)
					.build());

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.GUCCI)
					.yearOfCreation(2022)
					.price(1888.88)
					.createdAt(now)
					.build());

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.BALENCIAGA)
					.yearOfCreation(2023)
					.price(1749.0)
					.createdAt(now)
					.build());

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.DIOR)
					.yearOfCreation(2022)
					.price(1999.0)
					.createdAt(now)
					.build());

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.GUCCI)
					.yearOfCreation(2023)
					.price(1400.0)
					.createdAt(now)
					.build());

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.BALENCIAGA)
					.yearOfCreation(2023)
					.price(2050.0)
					.createdAt(now)
					.build());

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.DIOR)
					.yearOfCreation(2023)
					.price(1180.0)
					.createdAt(now)
					.build());

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.LOUIS_VUITTON)
					.yearOfCreation(2022)
					.price(1800.0)
					.createdAt(now)
					.build());

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.GUCCI)
					.yearOfCreation(2023)
					.price(1599.99)
					.createdAt(now)
					.build());

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.BALENCIAGA)
					.yearOfCreation(2022)
					.price(1799.99)
					.createdAt(now)
					.build());

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.DIOR)
					.yearOfCreation(2022)
					.price(1449.99)
					.createdAt(now)
					.build());

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.LOUIS_VUITTON)
					.yearOfCreation(2023)
					.price(1888.88)
					.createdAt(now)
					.build());

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.GUCCI)
					.yearOfCreation(2023)
					.price(1750.0)
					.createdAt(now)
					.build());

			repository.save(ItemModel.builder()
					.brand(ItemModel.FashionBrand.BALENCIAGA)
					.yearOfCreation(2022)
					.price(1999.0)
					.createdAt(now)
					.build());

		};
	}

}
