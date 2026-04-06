package com.mullitos.api.service.impl;

import com.mullitos.api.entity.Empleado;
import com.mullitos.api.repository.IEmpleadoRepository;
import com.mullitos.api.service.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements IEmpleadoService {

    private final IEmpleadoRepository repository;

    @Override
    public List<Empleado> findAll() {
        return repository.findAll();
    }
    @Override
    public Empleado findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }
    @Override
    public Empleado save(Empleado empleado) {
        return repository.save(empleado);
    }
    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
