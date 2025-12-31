package sv.com.eshop.core;

import java.util.List;

public interface CatalogItemRepository {
    List<CatalogItem> getCatalogItems();

    CatalogItem add(CatalogItem catalogItem);    
} 