package com.mullitos.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "productos")
@Getter @Setter
@Builder // ESTA ES LA QUE FALTA: Genera el método .builder()
@NoArgsConstructor // Necesario para JPA
@AllArgsConstructor // Necesario para Builder


public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    private Double precioBase;

    private Integer tiempoPrepEstimado;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
