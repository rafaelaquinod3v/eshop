package sv.com.eshop;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sv.com.eshop.core.CatalogTypeRepository;
import sv.com.eshop.core.entities.CatalogType;

@RestController
public class CatalogTypesController {

    private CatalogTypeRepository catalogTypeRepository;

    public CatalogTypesController(CatalogTypeRepository catalogTypeRepository) {
        this.catalogTypeRepository = catalogTypeRepository;
    }
    
    @GetMapping("catalog-types")
    public List<CatalogType> getCatalogTypes() {
        return this.catalogTypeRepository.findAll();
    }
}
