package sv.com.eshop.core;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItem {
    private OrderItemId id;
    private BigDecimal unitPrice;
    private int units;

    public static record OrderItemId(UUID id) {}
    
}
