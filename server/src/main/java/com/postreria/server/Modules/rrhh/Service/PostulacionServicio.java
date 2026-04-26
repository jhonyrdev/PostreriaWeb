package com.postreria.server.Modules.rrhh.Service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.postreria.server.Modules.rrhh.Dto.PostulacionDTO;
import com.postreria.server.Modules.rrhh.Entity.Postulacion;
import com.postreria.server.Modules.rrhh.Repository.PostulacionRepository;

import lombok.*;

@RequiredArgsConstructor
@Service
public class PostulacionServicio {

    private final PostulacionRepository post_res;

    public List<PostulacionDTO> obtenerPostulantes() {
        return post_res.obtenerPostulantes();
    }

    public Postulacion guardar(Postulacion postulacion) {
        return post_res.save(postulacion);
    }

    public List<Postulacion> listar(){
        return post_res.findAll();
    }

    public Postulacion buscar(int id){
        return post_res.findById(id).orElse(null);
    }

    public void eliminar(int id){
        post_res.deleteById(id);
    }
}
