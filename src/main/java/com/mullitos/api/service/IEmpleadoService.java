package com.mullitos.api.service;

import com.mullitos.api.entity.Empleado;
import java.util.List;

public interface IEmpleadoService {
    List<Empleado> findAll();
    Empleado findById(Integer id);
    Empleado save(Empleado empleado);
    void delete(Integer id);
}