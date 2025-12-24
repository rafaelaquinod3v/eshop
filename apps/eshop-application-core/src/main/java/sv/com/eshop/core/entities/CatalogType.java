package sv.com.eshop.core.entities;

import java.util.UUID;
import sv.com.eshop.core.entities.CatalogType.CatalogTypeId;;
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
        this.type = type;
    }

    public static record CatalogTypeId(UUID id) implements Identifier {}
}
