package com.example.HackaRec.Pedido.Repository;

import com.example.HackaRec.Pedido.Domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
