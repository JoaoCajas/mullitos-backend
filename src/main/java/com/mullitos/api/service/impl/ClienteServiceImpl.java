package com.mullitos.api.service.impl;

import com.mullitos.api.entity.Cliente;
import com.mullitos.api.repository.IClienteRepository;
import com.mullitos.api.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements IClienteService {

    private final IClienteRepository repository;

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }
    @Override
    public Cliente findById(Integer id) {
        // Si no lo encuentra, lanza una excepción (estilo PetClinic)
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + id));
    }
    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }
    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
