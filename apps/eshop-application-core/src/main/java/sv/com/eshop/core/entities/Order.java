package sv.com.eshop.core.entities;

import sv.com.eshop.core.entities.Order.OrderIdentifier;;
import java.util.UUID;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

public class Order implements AggregateRoot<Order, OrderIdentifier>{

    private OrderIdentifier id = new OrderIdentifier(UUID.randomUUID());
    
    public OrderIdentifier getId(){
        return this.id;
    }

    public static record OrderIdentifier(UUID id) implements Identifier {}
}