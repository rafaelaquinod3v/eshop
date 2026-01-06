package sv.com.eshop;

import org.springframework.web.bind.annotation.RestController;
import sv.com.eshop.core.CatalogBrandRepository;
import sv.com.eshop.core.entities.CatalogBrand;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CatalogBrandsController {

    private CatalogBrandRepository catalogBrandRepository;

    public CatalogBrandsController(CatalogBrandRepository catalogBrandRepository) {
        this.catalogBrandRepository = catalogBrandRepository;
    }
    
    @GetMapping("catalog-brands")
    public List<CatalogBrand> getCatalogBrands() {
        return this.catalogBrandRepository.findAll();
    }
    
}
