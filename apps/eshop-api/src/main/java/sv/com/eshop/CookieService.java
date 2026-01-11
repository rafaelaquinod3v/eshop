package sv.com.eshop;

import org.springframework.stereotype.Service;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CookieService {
    
    public void createBasketCookie(HttpServletResponse response, String username) {
        Cookie cookie = new Cookie("eShop", username);
        cookie.setPath("/");
        // cookie.setHttpOnly(true);
        // cookie.setSecure(true);
        cookie.setMaxAge(60 * 60 * 24 * 365 * 10);
        //cookie.setAttribute("SameSite", "None");
        response.addCookie(cookie);
    }
}
