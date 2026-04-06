package com.mullitos.api.controller;

import com.mullitos.api.dto.request.PedidoRequest;
import com.mullitos.api.dto.response.PedidoResponse;
import com.mullitos.api.entity.Pedido;
import com.mullitos.api.service.IPedidoService;
import com.mullitos.api.util.ModelMapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final IPedidoService service; // Cambiado a IPedidoService

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> findall(){
        List<Pedido> pedidos = service.findAll();
        List<PedidoResponse> response = pedidos.stream()
                .map(p -> ModelMapperUtil.convertTo(p, PedidoResponse.class))
                .toList();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> findById(@PathVariable Integer id){
        Pedido pedido = service.findById(id);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(pedido, PedidoResponse.class));
    }
    @PostMapping
    public ResponseEntity<PedidoResponse> save(@Valid @RequestBody PedidoRequest pedidoRequest){
        Pedido p = service.save(pedidoRequest);// Aquí el service.save ya procesa la lógica del total y los detalles
        return new ResponseEntity<>(ModelMapperUtil.convertTo(p, PedidoResponse.class), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}