package sv.com.eshop.infrastructure;

import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Component;
import sv.com.eshop.core.CatalogBrandRepository;
import sv.com.eshop.core.entities.CatalogBrand;

@Component
public class CatalogBrandRepositoryAdapter implements CatalogBrandRepository {

    private JpaCatalogBrandRepository jpaCatalogBrandRepository;

    public CatalogBrandRepositoryAdapter(JpaCatalogBrandRepository jpaCatalogBrandRepository) {
        this.jpaCatalogBrandRepository = jpaCatalogBrandRepository;
    }

    @Override
    public List<CatalogBrand> getCatalogBrands() {
        return this.jpaCatalogBrandRepository.findAll();        
    }

    @Override
    public CatalogBrand add(CatalogBrand catalogBrand) {
        Objects.requireNonNull(catalogBrand, "CatalogBrand cannot be null");
        return this.jpaCatalogBrandRepository.save(catalogBrand);
    }
    
}
