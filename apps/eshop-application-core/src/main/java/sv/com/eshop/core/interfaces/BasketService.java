package sv.com.eshop.core.interfaces;

import java.math.BigDecimal;
import java.util.Map;

import sv.com.eshop.core.CatalogItem.CatalogItemIdentifier;
import sv.com.eshop.core.entities.Basket;
import sv.com.eshop.core.entities.Basket.BasketIdentifier;

public interface BasketService {
    void transferBasket(String anonymousId, String username);
    Basket addItemToBasket(String username, CatalogItemIdentifier catalogItemId, BigDecimal price, int units);
    Basket setQuantities(BasketIdentifier id, Map<String, Integer> quantities);
    void deleteBasket(BasketIdentifier id);
}
