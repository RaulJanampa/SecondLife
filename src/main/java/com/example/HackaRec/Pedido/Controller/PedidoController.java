package com.example.HackaRec.Pedido.Controller;

import com.example.HackaRec.Pedido.Domain.Pedido;
import com.example.HackaRec.Pedido.Eventos.OrderCreatedEvent;
import com.example.HackaRec.Pedido.Repository.PedidoRepository;
import com.example.HackaRec.Pedido.Service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        Pedido creado = pedidoService.crearPedido(pedido);
        return ResponseEntity.ok(creado);
    }
}
