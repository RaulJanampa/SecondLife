package com.example.HackaRec.Pedido.Service;
import com.example.HackaRec.Pedido.Domain.Pedido;
import com.example.HackaRec.Pedido.Eventos.OrderCreatedEvent;
import com.example.HackaRec.Pedido.Repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ApplicationEventPublisher eventPublisher;

    public Pedido crearPedido(Pedido pedido) {
        Pedido saved = pedidoRepository.save(pedido);
        eventPublisher.publishEvent(new OrderCreatedEvent(this, saved.getId(), saved.getEmail(), saved.getProductos()));
        return saved;
    }
}