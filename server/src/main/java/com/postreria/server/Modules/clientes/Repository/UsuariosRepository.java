package com.postreria.server.Modules.clientes.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.postreria.server.Modules.clientes.Entity.Clientes;

@Repository
public interface UsuariosRepository extends JpaRepository<Clientes, Integer> {
    Clientes findByCorreo(String correo);

    @Query(value = "SELECT * FROM obtenerClientes()", nativeQuery = true)
    List<Clientes> obtenerUsuarios();

    Clientes findByTokenLogin(String token);

    Clientes findByTokenRecuperar(String token);

}
