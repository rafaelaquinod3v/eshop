package sv.com.eshop.core;

import java.util.List;

import sv.com.eshop.core.entities.CatalogBrand;

public interface CatalogBrandRepository {
    List<CatalogBrand> getCatalogBrands();
    CatalogBrand add(CatalogBrand catalogBrand);
}
