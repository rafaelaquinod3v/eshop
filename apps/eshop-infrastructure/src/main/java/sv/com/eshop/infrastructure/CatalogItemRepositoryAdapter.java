package sv.com.eshop.infrastructure;

import org.springframework.stereotype.Component;
import sv.com.eshop.core.CatalogItem;
import sv.com.eshop.core.CatalogItemRepository;
import sv.com.eshop.core.CatalogItem.CatalogItemIdentifier;

@Component
public class CatalogItemRepositoryAdapter extends BaseRepositoryAdapter<CatalogItem, CatalogItemIdentifier, JpaCatalogItemRepository> implements CatalogItemRepository {

    public CatalogItemRepositoryAdapter(JpaCatalogItemRepository jpaCatalogItemRepository) {
        super(jpaCatalogItemRepository);
    }
    
}
