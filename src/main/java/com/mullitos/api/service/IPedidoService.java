package com.mullitos.api.service;

import com.mullitos.api.dto.request.PedidoRequest;
import com.mullitos.api.entity.Pedido;
import java.util.List;

public interface IPedidoService {
    Pedido save(PedidoRequest request); // Recibe el DTO para procesar la lógica
    List<Pedido> findAll();
    Pedido findById(Integer id);
    void delete(Integer id);
}