package com.mullitos.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "Categoria")
@Data
@Builder // Genera el método .builder()
@NoArgsConstructor // Necesario para JPA
@AllArgsConstructor // Necesario para Builder

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    private Integer prioridad;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private Set<Producto> productos;

}
