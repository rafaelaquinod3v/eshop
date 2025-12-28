package sv.com.eshop.infrastructure;

import java.util.Objects;

import org.springframework.stereotype.Component;
import sv.com.eshop.core.BasketRepository;
import sv.com.eshop.core.entities.Basket;
import sv.com.eshop.core.entities.Basket.BasketIdentifier;

@Component
public class BasketRepositoryAdapter implements BasketRepository {

    private final JpaBasketRepository jpaBasketRepository;

    public BasketRepositoryAdapter(JpaBasketRepository jpaBasketRepository) {
        this.jpaBasketRepository = jpaBasketRepository;
    }

    @Override
    public void add(Basket basket) {
        Objects.requireNonNull(basket, "Basket cannot be null");
        this.jpaBasketRepository.save(basket);
    }

    @Override
    public void update(Basket basket) {
        Objects.requireNonNull(basket, "Basket cannot be null");
        // Al tener un ID ya asignado, JPA realizará un UPDATE en lugar de un INSERT
        this.jpaBasketRepository.save(basket);
    }

    @Override
    public Basket getById(BasketIdentifier id) {
        Objects.requireNonNull(id, "BasketIdentifier cannot be null");
        return this.jpaBasketRepository.findById(id).get();
    }

    @Override
    public Basket getByBuyerId(String buyerId) {
        return this.jpaBasketRepository.findByBuyerId(buyerId);
    }

    @Override
    public void delete(Basket basket) {
        Objects.requireNonNull(basket, "Basket cannot be null");
        this.jpaBasketRepository.delete(basket);
    }
    
}
