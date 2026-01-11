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
            var mug = CatalogType.create("Mug");
            var sheet = CatalogType.create("Sheet");
            var tShirt = CatalogType.create("T-Shirt");
            var usbMemoryStick = CatalogType.create("USB Memory Stick");

            catalogTypeRepository.save(mug);
            catalogTypeRepository.save(sheet);
            catalogTypeRepository.save(tShirt);
            catalogTypeRepository.save(usbMemoryStick);
            
            var dotnet = new CatalogBrand(".NET");
            var azure = new CatalogBrand("Azure");
            var other = new CatalogBrand("Other");
            var sqlServer = new CatalogBrand("SQL Server");
            var visualStudio = new CatalogBrand("Visual Studio");

            catalogBrandRepository.save(dotnet);
            catalogBrandRepository.save(azure);
            catalogBrandRepository.save(other);
            catalogBrandRepository.save(sqlServer);
            catalogBrandRepository.save(visualStudio);
            
            var item1 = new CatalogItem(".NET Bot Black Sweatshirt", "description", BigDecimal.valueOf(19.50), "1.png", tShirt.getId(), dotnet.getId());
            var item2 = new CatalogItem(".NET Black & White Mug", "description", BigDecimal.valueOf(8.50), "2.png", mug.getId(), dotnet.getId());
            var item3 = new CatalogItem("Prism White T-Shirt", "description", BigDecimal.valueOf(12), "3.png", tShirt.getId(), other.getId());
            var item4 = new CatalogItem(".NET Foundation Sweatshirt", "description", BigDecimal.valueOf(12), "4.png", tShirt.getId(), dotnet.getId());
            var item5 = new CatalogItem("Roslyn Red Sheet", "description", BigDecimal.valueOf(8.5), "5.png", sheet.getId(), other.getId());
            var item6 = new CatalogItem(".NET Blue Sweatshirt", "description", BigDecimal.valueOf(12), "6.png", tShirt.getId(), dotnet.getId());
            var item7 = new CatalogItem("Roslyn Red T-Shirt", "description", BigDecimal.valueOf(12), "7.png", tShirt.getId(), other.getId());
            var item8 = new CatalogItem("Kudu Purple Sweatshirt", "description", BigDecimal.valueOf(8.5), "8.png", tShirt.getId(), other.getId());

            catalogItemRepository.save(item1);
            catalogItemRepository.save(item2);
            catalogItemRepository.save(item3);
            catalogItemRepository.save(item4);
            catalogItemRepository.save(item5);
            catalogItemRepository.save(item6);
            catalogItemRepository.save(item7);
            catalogItemRepository.save(item8);

            System.out.println("Database initilized successfully.");
        };
    }
}
