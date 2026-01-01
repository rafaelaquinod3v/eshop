package sv.com.eshop.core;

import java.util.List;
import sv.com.eshop.core.entities.CatalogType;

public interface CatalogTypeRepository {
    List<CatalogType> getCatalogTypes();
    CatalogType add(CatalogType catalogType);
}
