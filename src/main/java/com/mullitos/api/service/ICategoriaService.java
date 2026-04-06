package com.mullitos.api.service;

import com.mullitos.api.entity.Categoria;

import java.util.List;

public interface ICategoriaService {
    public List<Categoria> findAll();
    public Categoria save(Categoria categoria);
    public Categoria update(Categoria categoria);
    public Categoria findById(Integer id);
    public void delete(Integer id);
}
