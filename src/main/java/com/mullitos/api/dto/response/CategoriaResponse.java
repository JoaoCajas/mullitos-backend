package com.mullitos.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponse {

    private Integer id;
    private String nombre;
    private Integer prioridad; // llama a los campos que realmente sean de la categoría
}

//    private Integer id;
//    @NotBlank(message = "El nombre no puede estar vacío")
//    private String nombre;
//
//    @Positive(message = "El precio debe ser mayor a 0")
//    private Double precioBase;
//
//    @Min(1)
//    private Integer tiempoPrepEstimado;
//
//    @NotNull(message = "Debe asignar una categoría")
//    private Categoria categoria;

