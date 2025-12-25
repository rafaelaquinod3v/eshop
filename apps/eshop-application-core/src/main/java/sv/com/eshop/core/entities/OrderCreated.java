package sv.com.eshop.core.entities;

import sv.com.eshop.core.entities.Order.OrderId;
import org.jmolecules.event.types.DomainEvent;

public record OrderCreated(OrderId orderId) implements DomainEvent {}
