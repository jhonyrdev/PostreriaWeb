package com.postreria.server.Modules.empleados.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;

import com.postreria.server.Modules.empleados.Dto.EmpleadoDTO;
import com.postreria.server.Modules.empleados.Entity.Empleado;

public interface EmpleadosRepository extends JpaRepository<Empleado, String> {
    @Query(value = "SELECT e.EMP_ID as id, e.EMP_NOM as nombre, e.EMP_APE as apellido, e.EMP_DNI as dni, e.EMP_TEL as telefono, e.EMP_COR as correo FROM EMPLEADOS e order by e.EMP_ID ASC", nativeQuery = true)
    List<EmpleadoDTO> obtenerEmpleados();
}
