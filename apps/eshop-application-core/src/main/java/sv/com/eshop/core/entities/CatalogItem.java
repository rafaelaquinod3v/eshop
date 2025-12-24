package sv.com.eshop.core.entities;

import sv.com.eshop.core.entities.CatalogItem.CatalogItemId;
import java.util.UUID;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

public class CatalogItem implements AggregateRoot<CatalogItem, CatalogItemId> {
    
    private CatalogItemId id = new CatalogItemId(UUID.randomUUID());
    private String name;
    private String description;
    private Double price;
    
    public CatalogItem(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public CatalogItemId getId(){
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Double getPrice() {
        return this.price;
    }

    public static record CatalogItemId(UUID id) implements Identifier {}
    
    @Override
    public String toString(){
        return "id: %s, name: %s, description: %s, price: %.2f".formatted(id.toString(), name, description, price);
    }
}
