package sv.com.eshop.core.entities.order.events;

import java.time.LocalDateTime;

import org.jmolecules.event.types.DomainEvent;

import sv.com.eshop.core.entities.Order;

public record OrderCreatedEvent(Order order, LocalDateTime dateTimeOcurred) implements DomainEvent {

    public OrderCreatedEvent(Order order) {
        this(order, LocalDateTime.now());
    }

    public Order getOrder() {
        return this.order;
    }

    public LocalDateTime getDateTimeOcurred() {
        return this.dateTimeOcurred;
    }
}
