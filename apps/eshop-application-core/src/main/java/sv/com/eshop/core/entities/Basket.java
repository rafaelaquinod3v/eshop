package sv.com.eshop.core.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

import sv.com.eshop.core.CatalogItem.CatalogItemId;

public class Basket implements AggregateRoot<Basket, Basket.BasketIdentifier> {
    
    private BasketIdentifier id;
    private String buyerId;
    private List<BasketItem> items = new ArrayList<>();
 
    @Override
    public BasketIdentifier getId() {
        return this.id;
    }

    public String getBuyerId() {
        return this.buyerId;
    }

    public List<BasketItem> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    public BigDecimal total() {
        return 
            this.items
            .stream()
            .map(BasketItem::subTotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addItem(CatalogItemId catalogItemId, BigDecimal unitPrice, int units) {
        Optional<BasketItem> existingItem = items.stream()
                .filter(i -> i.getCatalogItemId().equals(catalogItemId))
                .findFirst();

        if (existingItem.isPresent()) {
            BasketItem exists = existingItem.get();
            BasketItem newItem = new BasketItem(catalogItemId, unitPrice, exists.getUnits() + units);
            items.set(items.indexOf(exists), newItem);
        } else {
            items.add(new BasketItem(catalogItemId, unitPrice, units));
        }
    }
    
    public void removeEmptyItems() {
        items.removeIf(i -> i.getUnits() <= 0);
    }

    // Requerido por JPA (proxies/reflexión)
    protected Basket() {}
 
    public Basket(String buyerId) {
        Objects.requireNonNull(buyerId, "BuyerId cannot be null");
        this.id = new BasketIdentifier(UUID.randomUUID());
        this.buyerId = buyerId;
    }

    public static record BasketIdentifier(UUID id) implements Identifier {}
}
