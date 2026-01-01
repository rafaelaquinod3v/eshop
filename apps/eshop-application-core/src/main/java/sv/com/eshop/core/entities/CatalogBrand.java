package sv.com.eshop.core.entities;

import java.util.Objects;
import java.util.UUID;
import sv.com.eshop.core.entities.CatalogBrand.CatalogBrandIdentifier;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

public class CatalogBrand implements AggregateRoot <CatalogBrand, CatalogBrandIdentifier> {
    
    private CatalogBrandIdentifier id = new CatalogBrandIdentifier(UUID.randomUUID());
    private String brand;
    
    public CatalogBrandIdentifier getId() {
        return this.id;
    }

    public String getBrand() {
        return this.brand;
    }

    public CatalogBrand(String brand) {
        this.brand = brand;
    }

    protected CatalogBrand() {} // Required by JPA
    
    public static record CatalogBrandIdentifier(UUID id) implements Identifier {}

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof CatalogBrand that)) return false;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }
}
