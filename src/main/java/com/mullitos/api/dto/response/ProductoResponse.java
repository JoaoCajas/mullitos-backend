package com.mullitos.api.dto.response;

import com.mullitos.api.entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponse {
    private Integer id;
    private String nombre;
    private Double precioBase;
    private Categoria categoria;
}