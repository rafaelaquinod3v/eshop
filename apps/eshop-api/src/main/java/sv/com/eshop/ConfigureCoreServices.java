package sv.com.eshop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sv.com.eshop.core.BasketRepository;
import sv.com.eshop.core.BasketServiceImpl;
import sv.com.eshop.core.interfaces.BasketService;

@Configuration
public class ConfigureCoreServices {

/*     private BasketRepository basketRepository;

    public ConfigureCoreServices(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    } */

    @Bean
    public BasketService basketService(BasketRepository basketRepository) {
        return new BasketServiceImpl(basketRepository);
    }
}
