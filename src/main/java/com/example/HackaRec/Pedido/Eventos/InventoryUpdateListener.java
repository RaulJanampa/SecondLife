package com.example.HackaRec.Pedido.Eventos;

import com.example.HackaRec.Stock.Stock;
import com.example.HackaRec.Stock.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Log4j2
@Component
@RequiredArgsConstructor
public class InventoryUpdateListener {

    private final StockRepository stockRepository;

    @EventListener
    public void handleInventoryUpdate(OrderCreatedEvent event) {
        log.info("📦 Actualizando inventario para productos: " + event.getProductos());

        for (String producto : event.getProductos()) {
            Optional<Stock> stockOpt = stockRepository.findByNombreProducto(producto);
            if (stockOpt.isPresent()) {
                Stock stock = stockOpt.get();
                if (stock.getCantidadDisponible() > 0) {
                    stock.setCantidadDisponible(stock.getCantidadDisponible() - 1);
                    stockRepository.save(stock);
                    log.info("🔻 Stock actualizado para " + producto + ": " + stock.getCantidadDisponible() + " restantes.");
                } else {
                    log.warn("⚠️ Producto sin stock: " + producto);
                }
            } else {
                log.warn("❌ Producto no encontrado en inventario: " + producto);
            }
        }
    }
}
