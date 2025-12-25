package sv.com.eshop.core.entities;

import sv.com.eshop.core.OrderItem;
import sv.com.eshop.core.entities.Order.OrderId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

public class Order implements AggregateRoot<Order, OrderId>{

    private OrderId id;
    private Address shipToAddress;
    private String buyerId;
    private final List<OrderItem> orderItems = new ArrayList<>();
    
    private Order(OrderId id, String buyerId, Address shipToAddress, List<OrderItem> items){
        this.id = Objects.requireNonNull(id, "OrderId cannot be null");
        this.buyerId = buyerId;
        this.shipToAddress = shipToAddress;
        this.orderItems.addAll(items);
    }

    public static Order create(String buyerId, Address shipToAddress, List<OrderItem> items) {
        return new Order(new OrderId(UUID.randomUUID()), buyerId, shipToAddress, items);
    }

    public OrderId getId(){
        return this.id;
    }

    public static record OrderId(UUID id) implements Identifier {}

    @Override
    public String toString(){
        return "orderId: %s, buyerId: %s, addresss: %s".formatted(id.toString(), buyerId, shipToAddress.toString());
    }
}