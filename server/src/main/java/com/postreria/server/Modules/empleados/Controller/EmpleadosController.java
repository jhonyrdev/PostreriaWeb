package com.postreria.server.Modules.empleados.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.postreria.server.Modules.empleados.Entity.Empleado;
import com.postreria.server.Modules.empleados.Service.EmpleadosServicio;

import lombok.*;

@RequiredArgsConstructor
@Controller
public class EmpleadosController {

    private final EmpleadosServicio servicio;

    @GetMapping("/tablaEmpleados")
    public String mostrarTabla(Model modelo) {
        modelo.addAttribute("lista_Empleados", servicio.obtenerEmpleados());
        return "tablaEmpleados";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Empleado empleado) {
        servicio.guardar(empleado);
        return "redirect:/tablaEmpleados";
    }

    @GetMapping("/editarE/{id}")
    public String editar(@PathVariable("id") String id, Model modelo) {
        Empleado empleado = servicio.buscarPorID(id);
        modelo.addAttribute("lista_Empleados", empleado);
        return "edicionEmpleados";
    }

    @GetMapping("/eliminarE/{id}")
    public String eliminar(@PathVariable("id") String id) {
        servicio.eliminar(id);
        return "redirect:/tablaEmpleados";
    }

}
