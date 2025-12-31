package sv.com.eshop.core.entities;

import java.math.BigDecimal;
import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;

import sv.com.eshop.core.CatalogItem.CatalogItemIdentifier;

@ValueObject
public class BasketItem {

    private CatalogItemIdentifier catalogItemId;
    private BigDecimal unitPrice;
    private int units;

    public BasketItem(CatalogItemIdentifier catalogItemId, BigDecimal unitPrice, int units) {
        this.catalogItemId = catalogItemId;
        this.unitPrice = unitPrice;
        this.units = units;
    }

    public CatalogItemIdentifier getCatalogItemId() {
        return this.catalogItemId;
    }

    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public int getUnits() {
        return this.units;
    }

    public BigDecimal subTotal() {
        return this.unitPrice.multiply(BigDecimal.valueOf(units));
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof BasketItem that)) return false;
        return 
            Objects.equals(this.catalogItemId, that.getCatalogItemId()) &&
            Objects.equals(this.unitPrice, that.getUnitPrice()) &&
            Objects.equals(this.units, that.getUnits());
    }

    // Requerido por JPA (proxies/reflexión)
    protected BasketItem() {}

    @Override
    public int hashCode(){
        return Objects.hash(this.catalogItemId, this.unitPrice, this.units);
    }
}
