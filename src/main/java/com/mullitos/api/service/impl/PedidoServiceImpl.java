package com.mullitos.api.service.impl;

import com.mullitos.api.dto.request.PedidoRequest;
import com.mullitos.api.entity.*;
import com.mullitos.api.repository.*;
import com.mullitos.api.service.IPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements IPedidoService {

    private final IPedidoRepository pedidoRepository;
    private final IClienteRepository clienteRepository;
    private final IEmpleadoRepository empleadoRepository;
    private final IProductoRepository productoRepository;

    @Override
    @Transactional
    public Pedido save(PedidoRequest request) {
        // 1. Buscar Cliente y Empleado (si no existen, lanza error)
        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Empleado empleado = empleadoRepository.findById(request.getEmpleadoId())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        // 2. Crear la cabecera del Pedido
        Pedido pedido = Pedido.builder()
                .cliente(cliente)
                .empleado(empleado)
                .detalles(new ArrayList<>())
                .total(0.0)
                .build();

        // 3. Procesar los productos
        double totalAcumulado = 0.0;

        for (var detRequest : request.getDetalles()) {
            Producto producto = productoRepository.findById(detRequest.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado id: " + detRequest.getProductoId()));

            // Se crea el detalle con el precio actual del producto
            DetallePedido detalle = DetallePedido.builder()
                    .producto(producto)
                    .cantidad(detRequest.getCantidad())
                    .precioVentaMomento(producto.getPrecioBase())
                    .pedido(pedido)
                    .build();

            totalAcumulado += (detalle.getPrecioVentaMomento() * detalle.getCantidad());
            pedido.getDetalles().add(detalle);
        }

        // 4. Asignar el total final y guardar
        pedido.setTotal(totalAcumulado);
        return pedidoRepository.save(pedido);
    }
    @Override
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }
    @Override
    public Pedido findById(Integer id) {
        return pedidoRepository.findById(id).orElse(null);
    }
    @Override
    public void delete(Integer id) {
        pedidoRepository.deleteById(id);
    }
}