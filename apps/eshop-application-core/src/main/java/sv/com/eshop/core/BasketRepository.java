package sv.com.eshop.core;

import java.util.Optional;

import sv.com.eshop.core.entities.Basket;
import sv.com.eshop.core.entities.Basket.BasketIdentifier;

public interface BasketRepository extends DomainRepository<Basket, BasketIdentifier> {

    Optional<Basket> findByBuyerId(String buyerId);
    
}
