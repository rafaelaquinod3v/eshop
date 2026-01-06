package sv.com.eshop.infrastructure;

import java.util.Optional;
import org.springframework.stereotype.Component;
import sv.com.eshop.core.BasketRepository;
import sv.com.eshop.core.entities.Basket;
import sv.com.eshop.core.entities.Basket.BasketIdentifier;

@Component
public class BasketRepositoryAdapter extends BaseRepositoryAdapter<Basket, BasketIdentifier, JpaBasketRepository> implements BasketRepository {

    public BasketRepositoryAdapter(JpaBasketRepository jpaBasketRepository) {
        super(jpaBasketRepository);
    }

    @Override
    public Optional<Basket> findByBuyerId(String buyerId) {
        return this.repository.findByBuyerIdWithItems(buyerId);
    }
        
}
