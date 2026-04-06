package com.mullitos.api.dto.request;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class ProductoRequest {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Positive(message = "El precio debe ser mayor a 0")
    private Double precioBase;

    @Min(1)
    private Integer tiempoPrepEstimado;

    @NotNull(message = "Debe asignar una categoría")
    private Integer categoriaId;
}
