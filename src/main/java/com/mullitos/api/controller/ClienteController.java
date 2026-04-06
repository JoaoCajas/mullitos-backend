package com.mullitos.api.controller;

import com.mullitos.api.dto.request.ClienteRequest;
import com.mullitos.api.dto.response.ClienteResponse;
import com.mullitos.api.entity.Cliente;
import com.mullitos.api.service.IClienteService;
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

    private final IClienteService service; // Cambiado a IClienteService

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> findall(){
        List<Cliente> clients = service.findAll();
        List<ClienteResponse> response = clients.stream()
                .map(c -> ModelMapperUtil.convertTo(c, ClienteResponse.class))
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> findById(@PathVariable Integer id){
        return ResponseEntity.ok(ModelMapperUtil.convertTo(service.findById(id), ClienteResponse.class));
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> save(@Valid @RequestBody ClienteRequest clienteRequest){
        Cliente clienteToSave = ModelMapperUtil.convertTo(clienteRequest, Cliente.class);
        Cliente c = service.save(clienteToSave);
        return new ResponseEntity<>(ModelMapperUtil.convertTo(c, ClienteResponse.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> update(@PathVariable Integer id, @Valid @RequestBody ClienteRequest clienteRequest){
        Cliente clienteToUpdate = ModelMapperUtil.convertTo(clienteRequest, Cliente.class);
        clienteToUpdate.setId(id);
        Cliente updated = service.save(clienteToUpdate);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(updated, ClienteResponse.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}