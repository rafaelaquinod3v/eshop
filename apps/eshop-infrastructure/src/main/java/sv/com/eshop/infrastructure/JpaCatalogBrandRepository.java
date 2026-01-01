package sv.com.eshop.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.com.eshop.core.entities.CatalogBrand;
import sv.com.eshop.core.entities.CatalogBrand.CatalogBrandIdentifier;

public interface JpaCatalogBrandRepository extends JpaRepository<CatalogBrand, CatalogBrandIdentifier> {
    
}
