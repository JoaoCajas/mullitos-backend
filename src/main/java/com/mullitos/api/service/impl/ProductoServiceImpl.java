package com.mullitos.api.service.impl;


import com.mullitos.api.entity.Producto;
import com.mullitos.api.repository.IProductoRepository;
import com.mullitos.api.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements IProductoService {

    private final IProductoRepository repository;

//    public ProductoServiceImpl(IProductoRepository productoRepository) {
//        this.productoRepository = productoRepository;
//    }
//
//    public ProductoResponse obtenerPorId(Integer id) {
//        Producto producto = productoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
//        return ModelMapperUtil.convertTo(producto, ProductoResponse.class);
//    }
//
//    public ProductoResponse crear(ProductoRequest request) {
//        Producto producto = ModelMapperUtil.convertTo(request, Producto.class);
//        // Aquí podrías buscar la categoría real por ID si fuera necesario
//        Producto guardado = productoRepository.save(producto);
//        return ModelMapperUtil.convertTo(guardado, ProductoResponse.class);
//    }
//
//    public List<ProductoResponse> listarTodo() {
//        List<Producto> productos = productoRepository.findAll();
//        return productos.stream()
//                .map(p -> ModelMapperUtil.convertTo(p, ProductoResponse.class))
//                .collect(Collectors.toList());
//    }
//
//    public void eliminar(Integer id) {
//        // 1. Verificamos si existe (reutilizando la lógica de buscar)
//        if (!productoRepository.existsById(id)) {
//            throw new EntityNotFoundException("No se puede eliminar: Producto con ID " + id + " no encontrado");
//        }
//        // 2. Si existe, lo borramos
//        productoRepository.deleteById(id);
//    }

    @Override
    public List<Producto> findAll() {
        return repository.findAll();
    }

    @Override
    public Producto save(Producto producto) {
       return repository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto findById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
