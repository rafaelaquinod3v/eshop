package sv.com.eshop;

import org.springframework.web.bind.annotation.RestController;

import sv.com.eshop.core.CatalogBrandRepository;
import sv.com.eshop.core.entities.CatalogBrand;
import sv.com.eshop.infrastructure.CatalogBrandRepositoryAdapter;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CatalogBrandController {

    private CatalogBrandRepository catalogBrandRepository;

    public CatalogBrandController(CatalogBrandRepository catalogBrandRepository) {
        this.catalogBrandRepository = catalogBrandRepository;
    }
    
    @GetMapping("brands")
    public List<CatalogBrand> getCatalogBrands() {
        return this.catalogBrandRepository.getCatalogBrands();
    }
    
}
