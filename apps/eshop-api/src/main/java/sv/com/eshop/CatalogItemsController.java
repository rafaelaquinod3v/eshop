package sv.com.eshop;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import sv.com.eshop.core.CatalogItem;
import sv.com.eshop.core.CatalogItemRepository;
import sv.com.eshop.core.PageQuery;
import sv.com.eshop.core.PagedResult;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping("items")
    public PagedResult<CatalogItem> getItems(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "4") int size) {
        
        // Creas el objeto de dominio manualmente
        PageQuery query = new PageQuery(page, size);
        return this.catalogItemRepository.findAll(query);
    }
    
}
