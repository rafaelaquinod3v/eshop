package sv.com.eshop.core.entities.order.handlers;

import org.jmolecules.event.annotation.DomainEventHandler;
import sv.com.eshop.core.entities.order.events.OrderCreatedEvent;

public class OrderCreatedHandler {

    //private final EmailSender emailSender;

    @DomainEventHandler
    public void handle(OrderCreatedEvent event) {
        var orderId = event.getOrder().getId();
        System.out.println("%s".formatted(orderId.id()));
        //TODO: Send Email
    }
}
