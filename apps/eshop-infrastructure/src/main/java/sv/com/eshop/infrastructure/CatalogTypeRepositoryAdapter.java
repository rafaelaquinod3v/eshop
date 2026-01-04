package sv.com.eshop.infrastructure;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;
import sv.com.eshop.core.CatalogTypeRepository;
import sv.com.eshop.core.entities.CatalogType;

@Component
public class CatalogTypeRepositoryAdapter implements CatalogTypeRepository {

    private JpaCatalogTypeRepository jpaCatalogTypeRepository;

    public CatalogTypeRepositoryAdapter(JpaCatalogTypeRepository jpaCatalogTypeRepository) {
        this.jpaCatalogTypeRepository = jpaCatalogTypeRepository;
    }

    @Override
    public List<CatalogType> getCatalogTypes() {
        return this.jpaCatalogTypeRepository.findAll();
    }

    @Override
    public CatalogType add(CatalogType catalogType) {
        Objects.requireNonNull(catalogType, "CatalogType cannot be null");
        return this.jpaCatalogTypeRepository.save(catalogType);
    }
    
}
