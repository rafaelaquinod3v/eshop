package sv.com.eshop.core;

import sv.com.eshop.core.entities.Basket;
import sv.com.eshop.core.entities.Basket.BasketIdentifier;

public interface BasketRepository {
    void add(Basket basket);
    void update(Basket basket);
    Basket getById(BasketIdentifier id);
    Basket getByBuyerId(String buyerId);
    void delete(Basket basket);
}
