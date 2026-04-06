package com.mullitos.api.service;

import com.mullitos.api.entity.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> findAll();
    public Producto save(Producto producto);
    public Producto update(Producto producto);
    public Producto findById(Integer id);
    public void delete(Integer id);
}
