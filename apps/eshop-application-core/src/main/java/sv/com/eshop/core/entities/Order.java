package sv.com.eshop.core.entities;

import sv.com.eshop.core.entities.Order.OrderId;

import java.util.List;
import java.util.UUID;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

public class Order implements AggregateRoot<Order, OrderId>{

    private OrderId id = new OrderId(UUID.randomUUID());
    private Address shipToAddress;
    private String buyerId;
    public Order(String buyerId, Address shipToAddress, List<Object> items){
        this.buyerId = buyerId;
        this.shipToAddress = shipToAddress;
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