package com.mullitos.api.service;

import com.mullitos.api.dto.request.ProductoRequest;
import com.mullitos.api.dto.response.ProductoResponse;
import com.mullitos.api.entity.Producto;
import com.mullitos.api.repository.IProductoRepository;
import com.mullitos.api.util.ModelMapperUtil;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final IProductoRepository productoRepository;
    public ProductoService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public ProductoResponse obtenerPorId(Integer id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
        return ModelMapperUtil.convertTo(producto, ProductoResponse.class);
    }

    public ProductoResponse crear(ProductoRequest request) {
        Producto producto = ModelMapperUtil.convertTo(request, Producto.class);
        // Aquí podrías buscar la categoría real por ID si fuera necesario
        Producto guardado = productoRepository.save(producto);
        return ModelMapperUtil.convertTo(guardado, ProductoResponse.class);
    }

    public List<ProductoResponse> listarTodo() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream()
                .map(p -> ModelMapperUtil.convertTo(p, ProductoResponse.class))
                .collect(Collectors.toList());
    }
}
