package com.example.HackaRec;

import com.example.HackaRec.Stock.Stock;
import com.example.HackaRec.Stock.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class StockInitializer {

    @Bean
    public CommandLineRunner initStock(StockRepository stockRepository) {
        return args -> {
            List<String> productosIniciales = Arrays.asList("Pan", "Leche", "Huevos", "Café", "Azúcar");

            for (String producto : productosIniciales) {
                if (stockRepository.findByNombreProducto(producto).isEmpty()) {
                    Stock stock = new Stock();
                    stock.setNombreProducto(producto);
                    stock.setCantidadDisponible(100);
                    stockRepository.save(stock);
                    System.out.println("🟢 Stock creado para: " + producto + " (100 unidades)");
                }
            }
        };
    }
}