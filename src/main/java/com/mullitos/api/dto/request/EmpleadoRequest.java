package com.mullitos.api.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmpleadoRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @NotBlank(message = "Debe especificar un cargo (ej. Barista, Cajero)")
    private String rol;

    @NotNull(message = "El sueldo es obligatorio")
    @Positive(message = "El sueldo debe ser mayor a 0")
    private Double sueldo;

    @NotBlank(message = "El turno es obligatorio")
    private String turno;


}
