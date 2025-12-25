package sv.com.eshop.core.entities;

import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;

import sv.com.eshop.core.CatalogItem.CatalogItemId;

@ValueObject
public final class CatalogItemOrdered {

    private final CatalogItemId catalogItemId;
    private final String productName;
    private final String pictureUri;

    public CatalogItemOrdered(CatalogItemId catalogItemId, String productName, String pictureUri) {
        this.catalogItemId = Objects.requireNonNull(catalogItemId, "ID is required");
        this.productName = Objects.requireNonNull(productName, "ProductName is required");
        this.pictureUri = pictureUri;
    }

    public CatalogItemId getCatalogItemId() {
        return this.catalogItemId;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getPictureUri() {
        return this.pictureUri;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return  true;
        if(!(o instanceof CatalogItemOrdered that)) return false;
        return 
            Objects.equals(this.catalogItemId, that.getCatalogItemId()) &&
            Objects.equals(this.productName, that.getProductName()) &&
            Objects.equals(this.pictureUri, that.getPictureUri());  
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.catalogItemId, this.productName, this.pictureUri);
    }

    @Override
    public String toString() {
        return "CatalogItemOrdered[" +
                "catalogItemId=" + this.catalogItemId +
                ", productName='" + this.productName + '\'' +
                ", pictureUri='" + this.pictureUri + '\'' +
                ']';
    }
}
