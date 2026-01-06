package sv.com.eshop.core;

import java.util.List;
import org.jmolecules.ddd.annotation.Service;
import sv.com.eshop.core.interfaces.CatalogItemService;

@Service
public class CatalogItemServiceImpl implements CatalogItemService {

    private CatalogItemRepository catalogItemRepository;

    @Override
    public List<CatalogItem> getCatalogItems() {
        return this.catalogItemRepository.findAll();
    }

    @Override
    public CatalogItem add(CatalogItem catalogItem) {
        return this.catalogItemRepository.save(catalogItem);
    }    
}
