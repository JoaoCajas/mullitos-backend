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

    @Override
    public List<Producto> findAll() {
        return repository.findAll();
    }

    @Override
    public Producto save(Producto producto) {
        producto.setId(null);
        return repository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        return repository.save(producto);
    }
    @Override
    public List<Producto> saveAll(List<Producto> productos) {
        return repository.saveAll(productos);
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
