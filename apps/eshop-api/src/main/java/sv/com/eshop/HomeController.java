package sv.com.eshop;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sv.com.eshop.core.CatalogItem;
import sv.com.eshop.core.CatalogItem.CatalogItemId;
import sv.com.eshop.core.interfaces.BasketService;

@RestController
public class HomeController {
  private final BasketService basketService;

  public HomeController(BasketService basketService) {
    this.basketService = basketService;
  }
  
  @GetMapping("/hello")
  @Transactional
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    this.basketService.addItemToBasket("Anonymous01", new CatalogItemId(UUID.fromString("048cfa69-8092-4b38-8d83-81ab13c69095")), BigDecimal.valueOf(9.99), 25);
    return String.format(
      "Hello %s! %s", 
      name, 
      //new Order("1234", new Address("x", "a", "surf", "state", "sv"), null)
      new CatalogItem("Black T-Shirt", "Kirklan XL", BigDecimal.valueOf(9.99), null, null, null)
    );
  }
}
