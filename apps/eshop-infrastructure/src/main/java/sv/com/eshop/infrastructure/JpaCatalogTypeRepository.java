package sv.com.eshop.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.com.eshop.core.entities.CatalogType;
import sv.com.eshop.core.entities.CatalogType.CatalogTypeIdentifier;

public interface JpaCatalogTypeRepository extends JpaRepository<CatalogType, CatalogTypeIdentifier> {}
