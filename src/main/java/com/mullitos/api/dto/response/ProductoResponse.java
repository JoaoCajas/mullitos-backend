package com.mullitos.api.dto.response;

import lombok.Data;

@Data
public class ProductoResponse {
    private Integer id;
    private String nombre;
    private Double precioBase;
    private String categoriaNombre; // Solo el nombre, no toda la entidad
}