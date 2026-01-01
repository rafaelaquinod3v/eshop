package sv.com.eshop;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import sv.com.eshop.core.CatalogBrandRepository;
import sv.com.eshop.core.CatalogItem;
import sv.com.eshop.core.CatalogItemRepository;
import sv.com.eshop.core.entities.CatalogBrand;

@Configuration
public class DataInitializer {
    
    @Bean
   // @Profile("dev")
    CommandLineRunner initDatabase(CatalogBrandRepository catalogBrandRepository, CatalogItemRepository catalogItemRepository) {
        return args -> {
            var catalogBrand1 = new CatalogBrand("ADIDAS");
            var catalogBrand2 = new CatalogBrand("PUMA");

            catalogBrandRepository.add(catalogBrand1);
            catalogBrandRepository.add(catalogBrand2);

            var catalogItem1 = new CatalogItem("name", "description", BigDecimal.valueOf(5.99), "picture", null, null);
            var catalogItem2 = new CatalogItem("name", "description", BigDecimal.valueOf(6.99), "picture", null, null);

            catalogItemRepository.add(catalogItem1);
            catalogItemRepository.add(catalogItem2);

            System.out.println("Database initilized successfully.");
        };
    }
}
