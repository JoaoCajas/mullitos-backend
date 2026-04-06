package com.mullitos.api.dto.response;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data //
public class PedidoResponse {
    private Integer id;
    private LocalDateTime fecha;
    private String clienteNombre; // el nombre que uses en tu DTO
    private Double total;
    private List<DetallePedidoResponse> detalles;
}