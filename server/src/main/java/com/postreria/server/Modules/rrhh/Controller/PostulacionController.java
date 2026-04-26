package com.postreria.server.Modules.rrhh.Controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.postreria.server.Modules.rrhh.Entity.Postulacion;
import com.postreria.server.Modules.rrhh.Service.PostulacionServicio;

import lombok.*;

@RequiredArgsConstructor
@Controller
public class PostulacionController {

    private final PostulacionServicio servicio;

    // Mostrar formulario de postulación
    @GetMapping("/trabajo")
    public String mostrarFormulario(Model modelo){
        modelo.addAttribute("postulacion", new Postulacion());
        return "trabaja";  // tu formulario principal
    }

    // Guardar nueva postulación
    @PostMapping("/agregarPostulacion")
    public String agregar(@ModelAttribute Postulacion postulacion, Model modelo){
        servicio.guardar(postulacion);
        modelo.addAttribute("postulacion", new Postulacion());
        return "redirect:/trabajo";
    }

    // Mostrar tabla de postulaciones
    @GetMapping("/tablaPostulacion")
    public String mostrarTabla(Model modelo){
        modelo.addAttribute("lista_Postulacion", servicio.obtenerPostulantes());
        return "empleado";
    }

    // Eliminar postulante
    @GetMapping("/eliminarPostulacion/{id}")
    public String eliminar(@PathVariable int id){
        servicio.eliminar(id);
        return "redirect:/empleado";
    }


    @PostMapping("/buscarPostulante")
    public String buscar(@RequestParam int id, Model modelo){
        Postulacion p = servicio.buscar(id);
        List<Postulacion> resultado = new ArrayList<>();
    
        if(p != null) {
            resultado.add(p);
        }else{
            modelo.addAttribute("mensaje", "Este código no existe.");
        }

        modelo.addAttribute("lista_Postulacion", resultado);
        return "empleado";
    }
}
