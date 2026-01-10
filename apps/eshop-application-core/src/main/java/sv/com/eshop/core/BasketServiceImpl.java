package sv.com.eshop.core;

import java.math.BigDecimal;
import java.util.Map;
import org.jmolecules.ddd.annotation.Service;
import sv.com.eshop.core.CatalogItem.CatalogItemIdentifier;
import sv.com.eshop.core.entities.Basket;
import sv.com.eshop.core.entities.Basket.BasketIdentifier;
import sv.com.eshop.core.interfaces.BasketService;

@Service
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;

    public BasketServiceImpl(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    public void transferBasket(String anonymousId, String username) {
                
        var anonymousBasket = basketRepository.findByBuyerId(anonymousId).orElse(null);
        if(anonymousBasket == null) return;

        Basket userBasket = basketRepository.findByBuyerId(username).orElseGet(() -> new Basket(username));

        for(var item : anonymousBasket.getItems()) {
            userBasket.addItem(item.getCatalogItemId(), item.getUnitPrice(), item.getUnits());
        }

        basketRepository.save(userBasket);
        basketRepository.delete(anonymousBasket);
    }

    @Override
    public Basket addItemToBasket(String username, CatalogItemIdentifier catalogItemId, BigDecimal price, int units) {

            Basket basket = basketRepository.
                findByBuyerId(username).orElseGet(() -> basketRepository.save(new Basket(username)));

            basket.addItem(catalogItemId, price, units);
            basket = basketRepository.save(basket);
            return basket;
    }

    @Override
    public Basket setQuantities(BasketIdentifier id, Map<String, Integer> quantities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setQuantities'");
    }

    @Override
    public void deleteBasket(BasketIdentifier id) {
        var basketOpt = this.basketRepository.findById(id);
        if(basketOpt.isPresent()) {
            this.basketRepository.delete(basketOpt.get());
        }
    }
    
}
