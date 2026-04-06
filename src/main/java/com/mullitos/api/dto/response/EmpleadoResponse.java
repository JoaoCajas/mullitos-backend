package com.mullitos.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoResponse {
    private Integer id;
    private String nombre;
    private String apellido;
    private String rol;
    private Double sueldo;
}