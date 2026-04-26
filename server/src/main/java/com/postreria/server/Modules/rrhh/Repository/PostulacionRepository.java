package com.postreria.server.Modules.rrhh.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.postreria.server.Modules.rrhh.Dto.PostulacionDTO;
import com.postreria.server.Modules.rrhh.Entity.Postulacion;

@Repository
public interface PostulacionRepository extends JpaRepository<Postulacion, Integer> {
    @Query(value = "SELECT * FROM obtenerPostulantes()", nativeQuery = true)
    List<PostulacionDTO> obtenerPostulantes();
}
