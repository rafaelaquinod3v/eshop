package sv.com.eshop.infrastructure;

import org.springframework.stereotype.Component;
import sv.com.eshop.core.CatalogTypeRepository;
import sv.com.eshop.core.entities.CatalogType;
import sv.com.eshop.core.entities.CatalogType.CatalogTypeIdentifier;

@Component
public class CatalogTypeRepositoryAdapter extends BaseRepositoryAdapter<CatalogType, CatalogTypeIdentifier, JpaCatalogTypeRepository> implements CatalogTypeRepository {

    public CatalogTypeRepositoryAdapter(JpaCatalogTypeRepository jpaCatalogTypeRepository) {
        super(jpaCatalogTypeRepository);
    }
   
}
