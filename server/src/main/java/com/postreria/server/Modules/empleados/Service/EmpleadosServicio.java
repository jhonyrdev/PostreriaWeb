package com.postreria.server.Modules.empleados.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.postreria.server.Modules.empleados.Dto.EmpleadoDTO;
import com.postreria.server.Modules.empleados.Entity.Empleado;
import com.postreria.server.Modules.empleados.Repository.EmpleadosRepository;

import lombok.*;

@RequiredArgsConstructor
@Service
public class EmpleadosServicio {

    private final EmpleadosRepository empleados;

    public List<EmpleadoDTO> obtenerEmpleados(){
        return empleados.obtenerEmpleados();
    }
    
    public List<Empleado> listarTodos(){
        return empleados.findAll();
    }

    public Empleado buscarPorID(String codigo){
        return empleados.findById(codigo).orElse(null);
    }

    public Empleado guardar(Empleado empleado){
        return empleados.save(empleado);
    }

    public void eliminar(String id){
        empleados.deleteById(id);
    }

}
