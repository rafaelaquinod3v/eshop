package sv.com.eshop.core.entities;

import sv.com.eshop.core.entities.Order.OrderIdentifier;

import java.util.List;
import java.util.UUID;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

public class Order implements AggregateRoot<Order, OrderIdentifier>{

    private OrderIdentifier id = new OrderIdentifier(UUID.randomUUID());
    private Address shipToAddress;
    private String buyerId;
    public Order(String buyerId, Address shipToAddress, List<Object> items){
        this.buyerId = buyerId;
        this.shipToAddress = shipToAddress;
    }
    public OrderIdentifier getId(){
        return this.id;
    }

    public static record OrderIdentifier(UUID id) implements Identifier {}

    @Override
    public String toString(){
        return "orderId: %s, buyerId: %s, addresss: %s".formatted(id.toString(), buyerId, shipToAddress.toString());
    }
}