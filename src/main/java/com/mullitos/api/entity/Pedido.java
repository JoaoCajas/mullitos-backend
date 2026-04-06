package com.mullitos.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pedidos")
@Getter @Setter
@Builder // ESTA ES LA QUE FALTA: Genera el método .builder()
@NoArgsConstructor // Necesario para JPA
@AllArgsConstructor // Necesario para Builder

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private java.time.LocalDateTime fechaHora = java.time.LocalDateTime.now();
    private String estadoPedido;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private java.util.List<DetallePedido> detalles;
}
