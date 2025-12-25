package sv.com.eshop.core.entities;

import java.math.BigDecimal;
import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;

import sv.com.eshop.core.CatalogItem.CatalogItemId;

@ValueObject
public class BasketItem {

    private final CatalogItemId catalogItemId;
    private final BigDecimal unitPrice;
    private final int units;

    public BasketItem(CatalogItemId catalogItemId, BigDecimal unitPrice, int units) {
        this.catalogItemId = catalogItemId;
        this.unitPrice = unitPrice;
        this.units = units;
    }

    public CatalogItemId getCatalogItemId() {
        return this.catalogItemId;
    }

    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public int getUnits() {
        return this.units;
    }

    public BigDecimal getSubTotal() {
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

    @Override
    public int hashCode(){
        return Objects.hash(this.catalogItemId, this.unitPrice, this.units);
    }
}
