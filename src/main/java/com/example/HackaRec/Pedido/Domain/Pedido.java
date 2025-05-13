package com.example.HackaRec.Pedido.Domain;

<<<<<<< HEAD
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @ElementCollection
    private List<String> productos;
=======
public class Pedido {
>>>>>>> d78f3b0557200144d602095a66a57ccda75cb149
}
