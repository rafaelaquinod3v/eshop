package sv.com.eshop.core;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.Executors;
import sv.com.eshop.core.CatalogItem.CatalogItemId;
import sv.com.eshop.core.entities.Basket;
import sv.com.eshop.core.entities.Basket.BasketIdentifier;
import sv.com.eshop.core.interfaces.BasketService;

public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;

    public BasketServiceImpl(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    public void transferBasket(String anonymousId, String username) {
                
        var anonymousBasket = basketRepository.getByBuyerId(anonymousId).orElse(null);
        if(anonymousBasket == null) return;

        Basket userBasket = basketRepository.getByBuyerId(username).orElseGet(() -> new Basket(username));

        for(var item : anonymousBasket.getItems()) {
            userBasket.addItem(item.getCatalogItemId(), item.getUnitPrice(), item.getUnits());
        }

        basketRepository.update(userBasket);
        basketRepository.delete(anonymousBasket);
    }

    @Override
    public Basket addItemToBasket(String username, CatalogItemId catalogItemId, BigDecimal price, int units) {

            Basket basket = basketRepository.
                getByBuyerId(username).orElseGet(() -> basketRepository.add(new Basket(username)));
            
            basket.addItem(catalogItemId, price, units);
            basketRepository.update(basket);
            return basket;
    }

    @Override
    public Basket setQuantities(BasketIdentifier id, Map<String, Integer> quantities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setQuantities'");
    }

    @Override
    public void deleteBasket(BasketIdentifier id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBasket'");
    }
    
}
