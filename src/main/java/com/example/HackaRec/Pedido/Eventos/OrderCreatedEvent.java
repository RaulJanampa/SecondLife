package com.example.HackaRec.Pedido.Eventos;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import java.util.List;

@Getter
public class OrderCreatedEvent extends ApplicationEvent {
    private final Long orderId;
    private final String email;
    private final List<String> productos;

    public OrderCreatedEvent(Object source, Long orderId, String email, List<String> productos) {
        super(source);
        this.orderId = orderId;
        this.email = email;
        this.productos = productos;
    }
}
