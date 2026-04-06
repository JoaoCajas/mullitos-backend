package com.mullitos.api.service.impl;

import com.mullitos.api.entity.Categoria;
import com.mullitos.api.repository.ICategoriaRepository;
import com.mullitos.api.service.ICategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements ICategoriaService {

    private  final ICategoriaRepository repository;

    @Override
    public List<Categoria> findAll() {
        return repository.findAll();
    }

    @Override
    public Categoria save(Categoria categoria) {
        return  repository.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria) {
        return  repository.save(categoria);
    }

    @Override
    public Categoria findById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
