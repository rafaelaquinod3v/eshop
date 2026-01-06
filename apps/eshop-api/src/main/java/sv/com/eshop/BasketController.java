package sv.com.eshop;

import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BasketController {
    
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
