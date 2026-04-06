package com.mullitos.api.service;

import com.mullitos.api.entity.Cliente;
import java.util.List;

public interface IClienteService {
    List<Cliente> findAll();
    Cliente findById(Integer id);
    Cliente save(Cliente cliente);
    void delete(Integer id);
}