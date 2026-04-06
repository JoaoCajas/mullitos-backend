package com.mullitos.api.controller;

import com.mullitos.api.dto.request.CategoriaRequest;
import com.mullitos.api.dto.response.CategoriaResponse;
import com.mullitos.api.entity.Categoria;
import com.mullitos.api.service.ICategoriaService;
import com.mullitos.api.util.ModelMapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final ICategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> findAll() {
        List<Categoria> categorias = service.findAll();
        List<CategoriaResponse> response = categorias.stream()
                .map(c -> ModelMapperUtil.convertTo(c, CategoriaResponse.class))
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> findById(@PathVariable Integer id) {
        Categoria categoria = service.findById(id);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(categoria, CategoriaResponse.class));
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse> save(@Valid @RequestBody CategoriaRequest categoriaRequest) {
        Categoria categoriaToSave = ModelMapperUtil.convertTo(categoriaRequest, Categoria.class);
        Categoria saved = service.save(categoriaToSave);
        return new ResponseEntity<>(ModelMapperUtil.convertTo(saved, CategoriaResponse.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponse> update(@PathVariable Integer id, @Valid @RequestBody CategoriaRequest categoriaRequest) {
        Categoria categoriaToUpdate = ModelMapperUtil.convertTo(categoriaRequest, Categoria.class);
        categoriaToUpdate.setId(id);
        Categoria updated = service.save(categoriaToUpdate);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(updated, CategoriaResponse.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}