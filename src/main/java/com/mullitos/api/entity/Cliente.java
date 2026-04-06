package com.mullitos.api.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
@Builder // Genera el método .builder()
@NoArgsConstructor // Necesario para JPA
@AllArgsConstructor // Necesario para Builder

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;
}
