package sv.com.eshop;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import sv.com.eshop.core.CatalogBrandRepository;
import sv.com.eshop.core.CatalogItem;
import sv.com.eshop.core.CatalogItemRepository;
import sv.com.eshop.core.CatalogTypeRepository;
import sv.com.eshop.core.entities.CatalogBrand;
import sv.com.eshop.core.entities.CatalogType;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@Tag(name = "Catalog ", description = "APIs for catalog")
public class CatalogController {

    private CatalogTypeRepository catalogTypeRepository;
    private CatalogBrandRepository catalogBrandRepository;
    private CatalogItemRepository catalogItemRepository;

    public CatalogController(CatalogTypeRepository catalogTypeRepository, CatalogBrandRepository catalogBrandRepository, CatalogItemRepository catalogItemRepository) {
        this.catalogTypeRepository = catalogTypeRepository;
        this.catalogBrandRepository = catalogBrandRepository;
        this.catalogItemRepository = catalogItemRepository;
    }
    
    @GetMapping("types")
    public List<CatalogType> getCatalogTypes() {
        return this.catalogTypeRepository.getCatalogTypes();
    }
    
    
    @GetMapping("brands")
    public List<CatalogBrand> getCatalogBrands() {
        return this.catalogBrandRepository.getCatalogBrands();
    }
    
    @GetMapping("catalog-items")
    @Operation(summary = "Get all catalog items")
    public List<CatalogItem> getCatalogItems() {
        return this.catalogItemRepository.getCatalogItems();
    }
}
