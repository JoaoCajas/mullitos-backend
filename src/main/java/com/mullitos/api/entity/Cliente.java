package com.mullitos.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@Builder // ESTA ES LA QUE FALTA: Genera el método .builder()
@NoArgsConstructor // Necesario para JPA
@AllArgsConstructor // Necesario para Builder


public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private java.time.LocalDateTime horaLlegada;
    private String estadoActual; // Ej: "En espera", "Atendido"
}
