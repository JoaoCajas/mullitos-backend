package com.mullitos.api.controller;

import com.mullitos.api.dto.request.EmpleadoRequest;
import com.mullitos.api.dto.response.EmpleadoResponse;
import com.mullitos.api.entity.Empleado;
import com.mullitos.api.service.IEmpleadoService;
import com.mullitos.api.util.ModelMapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final IEmpleadoService service;

    @GetMapping
    public ResponseEntity<List<EmpleadoResponse>> findAll() {
        List<Empleado> people = service.findAll();
        List<EmpleadoResponse> peopleResponse = people.stream()
                .map(p -> ModelMapperUtil.convertTo(p, EmpleadoResponse.class))
                .toList();
        return ResponseEntity.ok(peopleResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponse> findById(@PathVariable Integer id) {
        // Cambiado ProductoResponse por EmpleadoResponse
        return ResponseEntity.ok(ModelMapperUtil.convertTo(service.findById(id), EmpleadoResponse.class));
    }

    @PostMapping
    public ResponseEntity<EmpleadoResponse> save(@Valid @RequestBody EmpleadoRequest request) {
        // Convertimos el Request a la Entidad Empleado
        Empleado entity = ModelMapperUtil.convertTo(request, Empleado.class);
        Empleado saved = service.save(entity);
        return new ResponseEntity<>(ModelMapperUtil.convertTo(saved, EmpleadoResponse.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoResponse> update(@PathVariable Integer id, @Valid @RequestBody EmpleadoRequest request) {
        Empleado entityToUpdate = ModelMapperUtil.convertTo(request, Empleado.class);
        entityToUpdate.setId(id);
        Empleado updated = service.save(entityToUpdate);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(updated, EmpleadoResponse.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}