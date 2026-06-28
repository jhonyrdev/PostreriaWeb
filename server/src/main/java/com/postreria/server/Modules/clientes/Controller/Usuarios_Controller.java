package com.postreria.server.Modules.clientes.Controller;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.postreria.server.Modules.clientes.Entity.Clientes;
import com.postreria.server.Modules.clientes.Service.UsuariosServicio;

import jakarta.servlet.http.HttpSession;
import lombok.*;

@RequiredArgsConstructor
@Controller
public class Usuarios_Controller {

    private final UsuariosServicio usuariosServicio;

    // Mostrar formulario de login
    @GetMapping("/login")
    public String login(Model modelo) {
        modelo.addAttribute("usuarios", new Clientes());
        return "login"; 
    }
    //mostrar formulario de registro
    @GetMapping("/registro")
    public String registro(Model modelo){
        modelo.addAttribute("usuarios", new Clientes());
        return "registro";
    }

    // ============================================
    // REGISTRO
    // ============================================

    // Registrar nuevo usuario
    @PostMapping("/agregar")
    public String agregar(@ModelAttribute Clientes usuario, RedirectAttributes redirectAttrs) {
        usuariosServicio.guardar(usuario);
        redirectAttrs.addFlashAttribute("mensaje", "¡Registro exitoso! Inicia sesión para continuar.");
        return "redirect:/login";
    }

    // ============================================
    // INICIO DE SESIÓN (1: VALIDAR CONTRASEÑA Y ENVIAR TOKEN)
    // ============================================

    @PostMapping("/iniciarSesion")
    public String iniciarSesion(@RequestParam String correo,
                                @RequestParam String contrasena,
                                RedirectAttributes redirectAttrs,
                                HttpSession session) {

        Clientes usuario = usuariosServicio.validarCredenciales(correo, contrasena);

        if (usuario == null) {
            redirectAttrs.addFlashAttribute("error", "Correo o contraseña incorrectos");
            return "redirect:/login";
        }

        // Generar token y enviar correo
        usuariosServicio.generarTokenLogin(usuario);

        // Guardar correo temporal para saber a quién validar
        session.setAttribute("correoPendiente", correo);
        session.setAttribute("usuarioLogueado", usuario);

        redirectAttrs.addFlashAttribute("mensaje", "Se ha enviado un token a tu correo.");
        return "redirect:/token-login";
    }

    // Mostrar vista para escribir token
    @GetMapping("/token-login")
    public String mostrarTokenLogin() {
        return "token_login";
    }

    // ============================================
    // INICIO DE SESIÓN (2: VALIDAR TOKEN)
    // ============================================

    @PostMapping("/validarToken")
    public String validarTokenLogin(@RequestParam String token,
                                    RedirectAttributes redirectAttrs,
                                    HttpSession session) {

        String correo = (String) session.getAttribute("correoPendiente");

        if (correo == null) {
            redirectAttrs.addFlashAttribute("error", "Error interno. Vuelve a iniciar sesión.");
            return "redirect:/login";
        }

        Clientes usuario = usuariosServicio.validarTokenLogin(token);

        if (usuario == null) {
            redirectAttrs.addFlashAttribute("error", "Token inválido o expirado.");
            return "redirect:/token-login";
        }

        // Token válido → iniciar sesión
        session.setAttribute("usuarioLogueado", usuario);
        session.removeAttribute("correoPendiente");

        return "redirect:/index";
    }
  // ============================================
    // MOSTRAR TABLA DE USUARIOS
    // ============================================

    // Mostrar tabla de usuarios
    @GetMapping("/tablaUsuarios")
    public String mostrarTabla(Model modelo) {
        List<Clientes> lista = usuariosServicio.listar();
        modelo.addAttribute("lista_usuarios", lista);
        return "tabla_usuarios"; // tabla_usuarios.html
    }

    // Eliminar usuario por ID
    @PostMapping("/eliminarUsuarios")
        public String eliminar(@RequestParam Integer id) {
            usuariosServicio.eliminar(id);
        return "redirect:/tabla_usuarios";
    }   

    // Buscar usuario por ID
    @PostMapping("/buscar")
    public String buscar(@RequestParam Integer id, Model modelo) {
        if (id == null) {
            modelo.addAttribute("mensaje", "Por favor ingresa un ID para buscar.");
            modelo.addAttribute("lista_usuarios", List.of());
        return "tabla_usuarios";
        }
        Optional<Clientes> usuario = usuariosServicio.buscarPorId(id);
        if (usuario.isPresent()) {
            modelo.addAttribute("lista_usuarios", List.of(usuario.get()));
        } else {
            modelo.addAttribute("mensaje", "Este ID no existe.");
            modelo.addAttribute("lista_usuarios", List.of());
        }
        return "tabla_usuarios";
    }

     // ============================================
    // RECUPERAR CONTRASEÑA (1: ENVIAR TOKEN)
    // ============================================

    @GetMapping("/recuperar")
    public String recuperar() {
        return "recuperar";
    }

    @PostMapping("/enviarTokenRecuperar")
    public String enviarTokenRecuperar(@RequestParam String correo,
                                       RedirectAttributes redirectAttrs,
                                       HttpSession session) {

        boolean enviado = usuariosServicio.generarTokenRecuperar(correo);

        if (!enviado) {
            redirectAttrs.addFlashAttribute("error", "El correo no está registrado.");
            return "redirect:/recuperar";
        }

        session.setAttribute("correoRecuperar", correo);
        redirectAttrs.addFlashAttribute("mensaje", "Revisa tu correo. Se envió un token.");
        return "redirect:/validar-token-recuperar";
    }

    @GetMapping("/validar-token-recuperar")
    public String mostrarTokenRecuperar() {
        return "token_recuperar";
    }

    // ============================================
    // RECUPERAR CONTRASEÑA (2: VALIDAR TOKEN)
    // ============================================

    @PostMapping("/validarTokenRecuperar")
    public String validarTokenRecuperar(@RequestParam String token,
                                        RedirectAttributes redirectAttrs,
                                        HttpSession session) {

        Clientes usuario = usuariosServicio.validarTokenRecuperar(token);

        if (usuario == null) {
            redirectAttrs.addFlashAttribute("error", "Token inválido o expirado.");
            return "redirect:/validar-token-recuperar";
        }

        session.setAttribute("correoCambiar", usuario.getCorreo());
        return "redirect:/restablecer";
    }

    // ============================================
    // RESTABLECER CONTRASEÑA
    // ============================================

    @GetMapping("/restablecer")
    public String restablecer(Model modelo, HttpSession session) {
        String correo = (String) session.getAttribute("correoCambiar");
        modelo.addAttribute("correo", correo);
        return "restablecer";
    }

    @PostMapping("/actualizarContrasena")
    public String actualizarContrasena(@RequestParam String correo,
                                       @RequestParam String contrasena,
                                       RedirectAttributes redirectAttrs,
                                       HttpSession session) {

        usuariosServicio.actualizarContrasena(correo, contrasena);
        session.removeAttribute("correoCambiar");

        redirectAttrs.addFlashAttribute("mensaje", "Contraseña actualizada. Ya puedes iniciar sesión.");
        return "redirect:/login";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    session.invalidate(); // Elimina todos los atributos de sesión
    return "redirect:/index";  // Redirige al inicio o donde prefieras
    }

}