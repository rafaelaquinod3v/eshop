package sv.com.eshop.core.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

import sv.com.eshop.core.CatalogItem.CatalogItemId;

public class Basket implements AggregateRoot<Basket, Basket.BasketIdentifier> {
    
    private BasketIdentifier id;
    private String buyerId;
    //private List<BasketItem> items = new ArrayList<>();
 
    @Override
    public BasketIdentifier getId() {
        return this.id;
    }

    public String getBuyerId() {
        return this.buyerId;
    }

/*     public List<BasketItem> getItems() {
        return Collections.unmodifiableList(this.items);
        return null;
    } */

    public BigDecimal total() {
        return null;
/*         return 
            this.items
            .stream()
            .map(BasketItem::getSubTotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add); */
    }

    public void addItem(CatalogItemId catalogItemId, BigDecimal unitPrice, int units) {
/*         if(items.stream().noneMatch(i -> i.getCatalogItemId().equals(catalogItemId))){
            items.add(new BasketItem(catalogItemId, unitPrice, units));
            return;
        }
        BasketItem exists = items.stream()
            .filter(i -> i.getCatalogItemId().equals(catalogItemId))
            .findFirst()
            .orElseThrow();

        BasketItem newItem = new BasketItem(catalogItemId, unitPrice, exists.getUnits() + units);
        items.replaceAll(item -> item.getCatalogItemId().equals(catalogItemId) ? newItem : item); */
    }

    public void removeEmptyItems() {
       /*  items.removeIf(i -> i.getUnits() <= 0); */
    }

    protected Basket() {} // Requerido por JPA
    // Hibernate puede usar esto, pero tu código de aplicación no lo verá 
    // si está en otro paquete (como suele pasar en DDD)
    private void setId(BasketIdentifier id) {
        this.id = id;
    }
    private void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public Basket(String buyerId) {
        Objects.requireNonNull(buyerId, "BuyerId cannot be null");
        this.id = new BasketIdentifier(UUID.randomUUID());
        this.buyerId = buyerId;
    }

    public static record BasketIdentifier(UUID id) implements Identifier {}
}
