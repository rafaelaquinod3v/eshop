package sv.com.eshop.infrastructure;

import org.springframework.stereotype.Component;
import sv.com.eshop.core.CatalogBrandRepository;
import sv.com.eshop.core.entities.CatalogBrand;
import sv.com.eshop.core.entities.CatalogBrand.CatalogBrandIdentifier;

@Component
public class CatalogBrandRepositoryAdapter extends BaseRepositoryAdapter<CatalogBrand, CatalogBrandIdentifier, JpaCatalogBrandRepository> implements CatalogBrandRepository {

    public CatalogBrandRepositoryAdapter(JpaCatalogBrandRepository jpaCatalogBrandRepository) {
        super(jpaCatalogBrandRepository);
    }

}
