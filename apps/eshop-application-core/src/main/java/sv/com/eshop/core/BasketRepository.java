package sv.com.eshop.core;

import java.util.Optional;

import sv.com.eshop.core.entities.Basket;
import sv.com.eshop.core.entities.Basket.BasketIdentifier;

public interface BasketRepository {
    Basket add(Basket basket);
    void update(Basket basket);
    Basket getById(BasketIdentifier id);
    Optional<Basket> getByBuyerId(String buyerId);
    void delete(Basket basket);
}
