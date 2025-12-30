package sv.com.eshop.core;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

import sv.com.eshop.core.entities.CatalogItemOrdered;

@Entity
public class OrderItem {
    
    @Identity
    private OrderItemIdentifier id;
    private CatalogItemOrdered itemOrdered;
    private BigDecimal unitPrice;
    private int units;

    public OrderItem(CatalogItemOrdered itemOrdered, BigDecimal unitPrice, int units) {
        
        // Validaciones de Invariantes (DDD)
        Objects.requireNonNull(itemOrdered, "El item ordenado no puede ser nulo");
        Objects.requireNonNull(unitPrice, "El precio unitario no puede ser nulo");
        if (units <= 0) throw new IllegalArgumentException("Las unidades deben ser mayores a cero");
        if (unitPrice.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("El precio no puede ser negativo");

        this.id = new OrderItemIdentifier(UUID.randomUUID());
        this.itemOrdered = itemOrdered;
        this.unitPrice = unitPrice;
        this.units = units;
    }

    public OrderItemIdentifier getId() {
        return this.id;
    }

    public CatalogItemOrdered getItemOrdered() {
        return  this.itemOrdered;
    }

    public BigDecimal getUnitPrice() {
        return  this.unitPrice;
    }

    public int getUnits() {
        return this.units;
    }

    public BigDecimal getSubTotal() {
        return this.unitPrice.multiply(BigDecimal.valueOf(units));
    }

    public static record OrderItemIdentifier(UUID id) {
        public OrderItemIdentifier {
            Objects.requireNonNull(id, "OrderItemIdentifier should not be null");
        }
    }
    
}
