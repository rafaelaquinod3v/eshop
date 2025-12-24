package sv.com.eshop.core.entities;

import java.util.UUID;
import sv.com.eshop.core.entities.CatalogBrand.CatalogBrandId;;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

public class CatalogBrand implements AggregateRoot <CatalogBrand, CatalogBrandId> {
    
    private CatalogBrandId id = new CatalogBrandId(UUID.randomUUID());
    private String brand;
    
    public CatalogBrandId getId() {
        return this.id;
    }

    public String getBrand() {
        return this.brand;
    }

    public CatalogBrand(String brand) {
        this.brand = brand;
    }
    
    public static record CatalogBrandId(UUID id) implements Identifier {}
}
