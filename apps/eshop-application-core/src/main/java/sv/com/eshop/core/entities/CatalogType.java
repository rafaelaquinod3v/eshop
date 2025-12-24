package sv.com.eshop.core.entities;

import java.util.Objects;
import java.util.UUID;
import sv.com.eshop.core.entities.CatalogType.CatalogTypeId;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

public class CatalogType implements AggregateRoot<CatalogType, CatalogTypeId> {
    
    private CatalogTypeId id = new CatalogTypeId(UUID.randomUUID());
    private String type;

    public CatalogTypeId getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public CatalogType(String type) {
        if(type == null || type.isEmpty()) throw new IllegalArgumentException("Type cannot be empty");
        this.type = type;
    }

    public static record CatalogTypeId(UUID id) implements Identifier {}

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof CatalogType that)) return false;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }
}
