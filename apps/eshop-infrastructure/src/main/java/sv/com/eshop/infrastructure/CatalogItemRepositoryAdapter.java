package sv.com.eshop.infrastructure;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import sv.com.eshop.core.CatalogItem;
import sv.com.eshop.core.CatalogItemRepository;

@Component
public class CatalogItemRepositoryAdapter implements CatalogItemRepository {

    private JpaCatalogItemRepository jpaCatalogItemRepository;

    public CatalogItemRepositoryAdapter(JpaCatalogItemRepository jpaCatalogItemRepository) {
        this.jpaCatalogItemRepository = jpaCatalogItemRepository;
    }

    @Override
    public List<CatalogItem> getCatalogItems() {
        return this.jpaCatalogItemRepository.findAll();
    }

    @Override
    public CatalogItem add(CatalogItem catalogItem) {
        Objects.requireNonNull(catalogItem, "CatalogItem cannot be null");
        return this.jpaCatalogItemRepository.save(catalogItem);
    }
    
}
