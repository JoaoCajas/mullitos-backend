package com.mullitos.api.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "id", "nombre", "apellido", "dni", "telefono", "email" })
public class ClienteResponse {
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;
}
