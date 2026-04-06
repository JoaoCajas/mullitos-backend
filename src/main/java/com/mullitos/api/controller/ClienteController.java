package com.mullitos.api.controller;

import com.mullitos.api.dto.request.ProductoRequest;
import com.mullitos.api.dto.response.ProductoResponse;
import com.mullitos.api.entity.Producto;
import com.mullitos.api.service.IProductoService;
import com.mullitos.api.util.ModelMapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final IProductoService service;

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> findall(){
        List<Producto> people = service.findAll();
        List<ProductoResponse> peopleResponse = people.stream().
                map(p -> ModelMapperUtil.convertTo(p,ProductoResponse.class))
                .toList();
        return ResponseEntity.ok(peopleResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> findById(@PathVariable Integer id){
       //Producto producto = service.findById(id);
        return ResponseEntity.ok( ModelMapperUtil.convertTo(service.findById(id), ProductoResponse.class) );
    }

    @PostMapping
    public ResponseEntity<ProductoResponse> save(@Valid @RequestBody ProductoRequest productoRequest){

        Producto productoToSave = ModelMapperUtil.convertTo( productoRequest, Producto.class);
        Producto p = service.save(productoToSave);

        return new ResponseEntity<>(ModelMapperUtil.convertTo(p, ProductoResponse.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponse> update(@PathVariable Integer id, @RequestBody ProductoRequest productoRequest){

        Producto productoToUpdate = ModelMapperUtil.convertTo( productoRequest, Producto.class);
        productoToUpdate.setId(id);
        Producto producto = service.save(productoToUpdate);

        return ResponseEntity.ok(ModelMapperUtil.convertTo( producto ,ProductoResponse.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}