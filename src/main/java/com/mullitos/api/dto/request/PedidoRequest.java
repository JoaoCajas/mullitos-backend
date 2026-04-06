package com.mullitos.api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
public class PedidoRequest {

    @NotNull(message = "El cliente es obligatorio")
    private Integer clienteId;

    @NotNull(message = "El empleado es obligatorio")
    private Integer empleadoId;

    private List<DetallePedidoRequest> detalles;
}
