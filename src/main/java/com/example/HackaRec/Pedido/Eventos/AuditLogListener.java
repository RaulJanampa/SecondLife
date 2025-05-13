package com.example.HackaRec.Pedido.Eventos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AuditLogListener {
    private static final Logger logger = LogManager.getLogger(AuditLogListener.class);

    @EventListener
    public void auditOrder(OrderCreatedEvent event) {
        logger.info("📝 Registro de auditoría: Pedido ID {} creado por {} con productos: {}",
                event.getOrderId(), event.getEmail(), event.getProductos());
    }
}
