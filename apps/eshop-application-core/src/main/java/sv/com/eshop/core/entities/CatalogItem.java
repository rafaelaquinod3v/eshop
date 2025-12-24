package sv.com.eshop.core.entities;

import sv.com.eshop.core.entities.CatalogItem.CatalogItemId;
import sv.com.eshop.core.entities.CatalogType.CatalogTypeId;
import sv.com.eshop.core.entities.CatalogBrand.CatalogBrandId;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

public class CatalogItem implements AggregateRoot<CatalogItem, CatalogItemId> {
    
    private CatalogItemId id = new CatalogItemId(UUID.randomUUID());
    private String name;
    private String description;
    private BigDecimal price;
    private String pictureUri;
    private CatalogTypeId catalogTypeId;
    private CatalogBrandId catalogBrandId;

    public CatalogItemId getId(){
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getPictureUri() {
        return this.pictureUri;
    }

    public CatalogTypeId getCatalogTypeId() {
        return this.catalogTypeId;
    }

    public CatalogBrandId geCatalogBrandId() {
        return this.catalogBrandId;
    }

    public CatalogItem(
        String name, 
        String description, 
        BigDecimal price, 
        String pictureUri, 
        CatalogTypeId catalogTypeId,
        CatalogBrandId catalogBrandId
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.pictureUri = pictureUri;
        this.catalogTypeId = catalogTypeId;
        this.catalogBrandId = catalogBrandId;
    }

    public void updateDetails(CatalogItemDetails details) {
        Objects.requireNonNull(details.name(), "Name cannot be null");
        if(details.name().isEmpty()) throw new IllegalArgumentException("Name cannot be empty");

        Objects.requireNonNull(details.description(), "Description cannot be null");

        if(details.price().compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Price must be greater than zero");

        this.name = details.name();
        this.description = details.description();
        this.price = details.price();
    }

    public void updatePictureUri(String pictureName) {
        if(pictureName == null || pictureName.isEmpty()) {
            this.pictureUri = "";
            return;
        }
        this.pictureUri = "images/products/%s?%d".formatted(pictureName, Instant.now().toEpochMilli());
    }

    public void updateType(CatalogTypeId catalogTypeId) {
        if(catalogTypeId == null) throw new IllegalArgumentException("Type must not be null");
        this.catalogTypeId = catalogTypeId;
    }

    public void updateBrand(CatalogBrandId catalogBrandId) {
        if(catalogBrandId == null) throw new IllegalArgumentException("Brand must not be null");
        this.catalogBrandId = catalogBrandId;
    }

    public static record CatalogItemId(UUID id) implements Identifier {}
    public record CatalogItemDetails(String name, String description, BigDecimal price) {}

    @Override
    public String toString(){
        return "id: %s, name: %s, description: %s, price: %.2f".formatted(id.toString(), name, description, price);
    }
}
