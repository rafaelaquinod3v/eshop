package sv.com.eshop.core.entities;

import sv.com.eshop.core.OrderItem;
import sv.com.eshop.core.entities.Order.OrderIdentifier;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

public class Order implements AggregateRoot<Order, OrderIdentifier>{

    private OrderIdentifier id;
    private LocalDateTime orderDateTime;
    private Address shipToAddress;
    private String buyerId;
    private final List<OrderItem> orderItems = new ArrayList<>();
    
    private Order(OrderIdentifier id, LocalDateTime orderDateTime, String buyerId, Address shipToAddress, List<OrderItem> items){
        this.id = Objects.requireNonNull(id, "OrderId cannot be null");
        this.orderDateTime = Objects.requireNonNull(orderDateTime, "OrderDateTime cannot be null");
        this.buyerId = buyerId;
        this.shipToAddress = shipToAddress;
        if(items == null || items.isEmpty()) throw new IllegalArgumentException("Order must have at least one item");
        this.orderItems.addAll(items);
    }

    public OrderIdentifier getId(){
        return this.id;
    }

    public LocalDateTime getOrderDateTime() {
        return this.orderDateTime;
    }

    public String getBuyerId() {
        return this.buyerId;
    }

    public Address getShipToAddress() {
        return  this.shipToAddress;
    }

    public List<OrderItem> getOrderItems() {
        return  Collections.unmodifiableList(this.orderItems);
    }

    public static Order create(String buyerId, Address shipToAddress, List<OrderItem> items) {
        return new Order(new OrderIdentifier(UUID.randomUUID()), LocalDateTime.now(), buyerId, shipToAddress, items);
    }

    public BigDecimal total() {
        return this.orderItems
            .stream()
            .map(OrderItem::getSubTotal)
            .filter(Objects::nonNull)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static record OrderIdentifier(UUID id) implements Identifier {}

    @Override
    public String toString(){
        return "orderId: %s, buyerId: %s, addresss: %s".formatted(id.toString(), buyerId, shipToAddress.toString());
    }
}