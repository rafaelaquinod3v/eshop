package sv.com.eshop;

import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import sv.com.eshop.core.CatalogItemRepository;
import sv.com.eshop.core.entities.Basket;
import sv.com.eshop.core.CatalogItem.CatalogItemIdentifier;
import sv.com.eshop.core.interfaces.BasketService;
import sv.com.eshop.dto.AddItemRequest;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BasketController {

    private CookieService cookieService;
    private BasketService basketService;
    private CatalogItemRepository catalogItemRepository;

    public BasketController(CookieService cookieService, BasketService basketService, CatalogItemRepository catalogItemRepository) {
        this.cookieService = cookieService;
        this.basketService = basketService;
        this.catalogItemRepository = catalogItemRepository;
    }

    @PostMapping("/basket/items")
    public Basket addToBasket(
        @RequestBody AddItemRequest request,
        @CookieValue(value = "eShop", required = false) String basketCookie,
        HttpServletResponse response,
        Authentication auth
    ) {
        String username = null;

        if(auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
            username = auth.getName();
           // return "auth";
           // return ResponseEntity.ok(Collections.singletonMap("eShop", username));
        }

        if(basketCookie != null) {
            if(isValidUUID(basketCookie)) {
                username = basketCookie;
            }
        }

        if(username == null){
            username = UUID.randomUUID().toString();
            this.cookieService.createBasketCookie(response, username);
        }      
        var catalogItemId = new CatalogItemIdentifier(UUID.fromString(request.catalogItemId()));
        var opt = this.catalogItemRepository.findById(catalogItemId);
        Basket basket = null;
        System.out.println(catalogItemId);
        System.out.println(request);
        System.out.println(basketCookie);
        if(opt.isPresent()){
            var itemPrice = opt.get().getPrice();
            basket = this.basketService.addItemToBasket(username, catalogItemId, itemPrice, request.units());
        }         
        return basket;
    }
    
    
    @GetMapping("cookie")
    public ResponseEntity<Map<String, String>> getOrSetBasketCookieAndUsername(
        @CookieValue(value = "eShop", required = false) String basketCookie,
        HttpServletResponse response,
        Authentication auth
    ) {
        String username = null;

        if(auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
            username = auth.getName();
            return ResponseEntity.ok(Collections.singletonMap("eShop", username));
        }

        if(basketCookie != null) {
            if(isValidUUID(basketCookie)) {
                username = basketCookie;
            }
        }

        if(username == null){
            username = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("eShop", username);
            cookie.setPath("/");
            // cookie.setHttpOnly(true);
            // cookie.setSecure(true);
            cookie.setMaxAge(60 * 60 * 24 * 365 * 10);
            //cookie.setAttribute("SameSite", "None");
            response.addCookie(cookie);
        }
        return ResponseEntity.ok(Collections.singletonMap("eShop", username));
    }
    
    private boolean isValidUUID(String str) {
        try {
            UUID.fromString(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
