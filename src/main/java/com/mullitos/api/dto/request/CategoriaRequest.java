package com.mullitos.api.dto.request;

import com.mullitos.api.entity.Categoria;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
//@NoArgsConstructor
public class CategoriaRequest {
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
}
