package com.mullitos.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empleados")
@Getter @Setter
@Builder // Genera el método .builder()
@NoArgsConstructor // Necesario para JPA
@AllArgsConstructor // Necesario para Builder

public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private String rol;
    private Double sueldo;
    private String turno;

}
