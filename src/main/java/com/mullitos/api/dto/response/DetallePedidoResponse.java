package com.mullitos.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoResponse {
    private Integer id;
    private String productoNombre; // Para que en el JSON salga el nombre del café/postre
    private Integer cantidad;
    private Double precioVentaMomento;
    public Double getSubtotal() {
        if (precioVentaMomento != null && cantidad != null) {
            return precioVentaMomento * cantidad;
        }
        return 0.0;
    }
}