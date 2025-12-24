package sv.com.eshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import sv.com.eshop.core.entities.Address;
import sv.com.eshop.core.entities.CatalogItem;
//import sv.com.eshop.core.entities.Order;

@RestController
public class HomeController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format(
        "Hello %s! %s", 
        name, 
        //new Order("1234", new Address("x", "a", "surf", "state", "sv"), null)
        new CatalogItem("Black T-Shirt", "Kirklan XL", 9.99)
      );
    }
}
