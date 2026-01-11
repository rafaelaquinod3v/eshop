package sv.com.eshop.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.com.eshop.core.CatalogItem;
import sv.com.eshop.core.CatalogItem.CatalogItemIdentifier;

public interface JpaCatalogItemRepository extends JpaRepository<CatalogItem, CatalogItemIdentifier> {}
