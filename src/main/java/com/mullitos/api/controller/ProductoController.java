package com.mullitos.api.controller;

import com.mullitos.api.dto.request.ProductoRequest;
import com.mullitos.api.dto.response.ProductoResponse;
import com.mullitos.api.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor // <--- Esto hace toda la magia
public class ProductoController {

    private final ProductoService productoService;

    // Al usar @RequiredArgsConstructor ya no necesitas escribir el constructor manual

    @GetMapping
    public List<ProductoResponse> getProductos() {
        return productoService.listarTodo();
    }

    @GetMapping("/{id}")
    public ProductoResponse getPorId(@PathVariable Integer id) {
        return productoService.obtenerPorId(id);
    }

    @PostMapping
    public ProductoResponse crear(@RequestBody ProductoRequest request) {
        return productoService.crear(request);
    }
}