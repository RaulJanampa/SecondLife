package com.example.HackaRec.Pedido.Eventos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {
    private static final Logger logger = LogManager.getLogger(EmailNotificationListener.class);

    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        logger.info("📧 Email enviado a {} confirmando pedido ID {} con productos: {}",
                event.getEmail(), event.getOrderId(), event.getProductos());
    }
}
