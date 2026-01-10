package sv.com.eshop;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import sv.com.eshop.core.CatalogItemRepository;
import sv.com.eshop.core.entities.Basket;
import sv.com.eshop.core.CatalogItem;
import sv.com.eshop.core.CatalogItem.CatalogItemIdentifier;
import sv.com.eshop.core.interfaces.BasketService;
import sv.com.eshop.dto.AddItemRequest;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
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
        // 1. Obtener el item del catálogo una sola vez
        var catalogItemId = new CatalogItemIdentifier(UUID.fromString(request.catalogItemId()));
        var catalogItem = catalogItemRepository.findById(catalogItemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item no encontrado"));

        // 2. Determinar el identificador del usuario (Username o Cookie ID)
        String basketOwnerId = resolveBasketOwnerId(auth, basketCookie, response);

        // 3. Ejecutar la lógica de negocio una sola vez
        return basketService.addItemToBasket(
                basketOwnerId, 
                catalogItemId, 
                catalogItem.getPrice(), 
                request.units()
        );
    }

    private String resolveBasketOwnerId(Authentication auth, String basketCookie, HttpServletResponse response) {
        // Si el usuario está autenticado, su nombre es el ID prioritario
        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
            return auth.getName();
        }

        // Si no está autenticado, buscar en la cookie existente
        if (basketCookie != null && isValidUUID(basketCookie)) {
            return basketCookie;
        }

        // Si no hay cookie válida, generar una nueva y setearla
        String newGuestId = UUID.randomUUID().toString();
        cookieService.createBasketCookie(response, newGuestId);
        return newGuestId;
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
