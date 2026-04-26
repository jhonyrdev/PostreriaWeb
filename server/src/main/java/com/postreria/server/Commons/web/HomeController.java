package com.postreria.server.Commons.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import lombok.*;

@RequiredArgsConstructor
@Controller
public class HomeController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
    
    @GetMapping("/contacto")
    public String contacto(){
        return "contacto";
    }

    @GetMapping("/nosotros")
    public String nosotros(){
        return "nosotros";
    }

    @GetMapping("/postres")
    public String postres(){
        return "postres";
    }

    @GetMapping("/pedidos")
    public String pedidos(){
        return "pedidos";
    }

    @GetMapping("/vermas")
    public String vermas(){
        return "vermas";
    }

    
    @GetMapping("/masvendidos")
    public String masvendidos(){
        return "masvendidos";
    }

    @GetMapping("/evolucionventas")
    public String evolucionventas(){
        return "evolucionventas";
    }

    @GetMapping("/empleado")
        public String redirigirEmpleado(){
        return "redirect:/tablaPostulacion";
    }

    @GetMapping("/empleados")
        public String redirigirEmpleados(){
        return "redirect:/tablaEmpleados";
    }
       
    @GetMapping("/pago")
       public String pago() {
       return "pago"; 
    }

}
