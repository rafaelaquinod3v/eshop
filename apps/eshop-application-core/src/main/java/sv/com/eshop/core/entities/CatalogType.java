package sv.com.eshop.core.entities;

import java.util.Objects;
import java.util.UUID;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

public class CatalogType implements AggregateRoot<CatalogType, CatalogType.CatalogTypeId> {
    
    private final CatalogTypeId id;
    private final String type;

    @Override
    public CatalogTypeId getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    private CatalogType(CatalogTypeId id, String type) {
        validateType(type);
        this.id = Objects.requireNonNull(id, "CatalogTypeId cannot be null");
        this.type = type.trim();
    }

    public static CatalogType create(String type){
        return new CatalogType(new CatalogTypeId(UUID.randomUUID()), type);
    }

    public static CatalogType of(CatalogTypeId id, String type) {
        return new CatalogType(id, type);
    }

    public static record CatalogTypeId(UUID id) implements Identifier {
        public CatalogTypeId {
            Objects.requireNonNull(id, "Id UUID cannot be null");
        }
    }

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

    private void validateType(String type) {
        if(type == null || type.isBlank()) throw new IllegalArgumentException("CatalogType cannot be null or empty");
        if(type.length() < 3) throw new IllegalArgumentException("CatalogType should be at least 3 of length");
    }
}
