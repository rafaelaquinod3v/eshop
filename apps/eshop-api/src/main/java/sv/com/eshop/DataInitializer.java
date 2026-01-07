package sv.com.eshop;

import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sv.com.eshop.core.CatalogBrandRepository;
import sv.com.eshop.core.CatalogItem;
import sv.com.eshop.core.CatalogItemRepository;
import sv.com.eshop.core.CatalogTypeRepository;
import sv.com.eshop.core.entities.CatalogBrand;
import sv.com.eshop.core.entities.CatalogType;

@Configuration
public class DataInitializer {
    
    @Bean
    CommandLineRunner initDatabase(CatalogTypeRepository catalogTypeRepository, CatalogBrandRepository catalogBrandRepository, CatalogItemRepository catalogItemRepository) {
        return args -> {
            var catalogType1 = CatalogType.create("SHOES");
            var catalogType2 = CatalogType.create("ACCESSORIES");

            catalogTypeRepository.save(catalogType1);
            catalogTypeRepository.save(catalogType2);
            
            var catalogBrand1 = new CatalogBrand("ADIDAS");
            var catalogBrand2 = new CatalogBrand("PUMA");

            catalogBrandRepository.save(catalogBrand1);
            catalogBrandRepository.save(catalogBrand2);

            var catalogItem1 = new CatalogItem("name", "description", BigDecimal.valueOf(5.99), "picture", null, null);
            var catalogItem2 = new CatalogItem("name", "description", BigDecimal.valueOf(6.99), "picture", null, null);

            catalogItemRepository.save(catalogItem1);
            catalogItemRepository.save(catalogItem2);

            System.out.println("Database initilized successfully.");
        };
    }
}
