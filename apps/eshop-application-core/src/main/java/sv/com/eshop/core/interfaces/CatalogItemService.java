package sv.com.eshop.core.interfaces;

import java.util.List;

import sv.com.eshop.core.CatalogItem;

public interface CatalogItemService {
    List<CatalogItem> getCatalogItems();
    CatalogItem add(CatalogItem catalogItem);
}
