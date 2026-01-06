package sv.com.eshop;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import sv.com.eshop.core.CatalogItem;
import sv.com.eshop.core.CatalogItemRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@Tag(name = "Catalog ", description = "APIs for catalog")
public class CatalogItemsController {

    private CatalogItemRepository catalogItemRepository;

    public CatalogItemsController(CatalogItemRepository catalogItemRepository) {
        this.catalogItemRepository = catalogItemRepository;
    }
    
    @GetMapping("catalog-items")
    @Operation(summary = "Get all catalog items")
    public List<CatalogItem> getCatalogItems() {
        return this.catalogItemRepository.findAll();
    }
}
