package com.mullitos.api.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mullitos.api.entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "id", "nombre", "precioBase", "tiempoPrepEstimado", "categoria" }) // aqui definimos el orden
public class ProductoResponse {
    private Integer id;
    private String nombre;
    private Double precioBase;
    private Integer tiempoPrepEstimado;
    private CategoriaResponse categoria;
}