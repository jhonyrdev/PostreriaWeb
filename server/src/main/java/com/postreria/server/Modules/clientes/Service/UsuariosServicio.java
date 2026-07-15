package com.postreria.server.Modules.clientes.Service;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.postreria.server.Modules.clientes.Entity.Clientes;
import com.postreria.server.Modules.clientes.Repository.UsuariosRepository;

import lombok.*;

@RequiredArgsConstructor
@Service
public class UsuariosServicio {

    private final UsuariosRepository usuariosRepository;
    private final JavaMailSender mailSender;
    private final PasswordEncoder passwordEncoder;

    private final Random random = new Random();

    // Registrar usuario
    public Clientes guardar(Clientes usuario) {
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        return usuariosRepository.save(usuario);
    }

    // Listar todos
    public List<Clientes> listar() {
        return usuariosRepository.obtenerUsuarios();
    }

    // Buscar por ID
    public Optional<Clientes> buscarPorId(Integer id) {
        return usuariosRepository.findById(id);
    }

    // Eliminar por ID
    public void eliminar(Integer id) {
        usuariosRepository.deleteById(id);
    }

    // Buscar por correo
    public Clientes buscarPorCorreo(String correo) {
        return usuariosRepository.findByCorreo(correo);
    }

    // ============================================================
    // LOGIN (1) VALIDAR CREDENCIALES
    // ============================================================

    public Clientes validarCredenciales(String correo, String contrasena) {
        Clientes u = usuariosRepository.findByCorreo(correo);
        if (u == null)
            return null;

        if (!passwordEncoder.matches(contrasena, u.getContrasena())) {
            return null;
        }

        return u;
    }

    // ============================================================
    // LOGIN (2) GENERAR TOKEN
    // ============================================================

    public void generarTokenLogin(Clientes usuario) {
        String token = generarCodigo();
        usuario.setTokenLogin(token);
        usuario.setTokenLoginExpira(LocalDateTime.now().plusMinutes(5));
        usuariosRepository.save(usuario);

        enviarCorreo(usuario.getCorreo(),
                "Código de inicio de sesión",
                "Tu código para iniciar sesión es: " + token);
    }

    // ============================================================
    // LOGIN (3) VALIDAR TOKEN
    // ============================================================

    public Clientes validarTokenLogin(String token) {
        Clientes u = usuariosRepository.findByTokenLogin(token);
        if (u == null)
            return null;

        if (u.getTokenLoginExpira().isBefore(LocalDateTime.now()))
            return null;

        // token válido → eliminar
        u.setTokenLogin(null);
        u.setTokenLoginExpira(null);
        usuariosRepository.save(u);

        return u;
    }

    // ============================================================
    // RECUPERAR CONTRASEÑA (1) GENERAR TOKEN
    // ============================================================

    public boolean generarTokenRecuperar(String correo) {
        Clientes u = usuariosRepository.findByCorreo(correo);
        if (u == null)
            return false;

        String token = generarCodigo();
        u.setTokenRecuperar(token);
        u.setTokenRecuperarExpira(LocalDateTime.now().plusMinutes(10));
        usuariosRepository.save(u);

        enviarCorreo(correo,
                "Código para recuperar contraseña",
                "Tu código para recuperar tu cuenta es: " + token);

        return true;
    }

    // ============================================================
    // RECUPERAR CONTRASEÑA (2) VALIDAR TOKEN
    // ============================================================

    public Clientes validarTokenRecuperar(String token) {
        Clientes u = usuariosRepository.findByTokenRecuperar(token);
        if (u == null)
            return null;

        if (u.getTokenRecuperarExpira().isBefore(LocalDateTime.now()))
            return null;

        return u;
    }

    // ============================================================
    // RECUPERAR CONTRASEÑA (3) ACTUALIZAR CONTRASEÑA
    // ============================================================

    public void actualizarContrasena(String correo, String nuevaContrasena) {
        Clientes u = usuariosRepository.findByCorreo(correo);
        u.setContrasena(passwordEncoder.encode(nuevaContrasena));
        u.setTokenRecuperar(null);
        u.setTokenRecuperarExpira(null);
        usuariosRepository.save(u);
    }

    // ============================================================
    // CORREO
    // ============================================================

    private void enviarCorreo(String para, String asunto, String cuerpo) {
        try {
            SimpleMailMessage mensaje = new SimpleMailMessage();
            mensaje.setTo(para);
            mensaje.setSubject(asunto);
            mensaje.setText(cuerpo);

            mailSender.send(mensaje);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error enviando correo", e);
        }
    }

    // ============================================================
    // GENERAR TOKEN NUMÉRICO DE 6 DÍGITOS
    // ============================================================

    private String generarCodigo() {
        int codigo = random.nextInt(900000) + 100000;
        return String.valueOf(codigo);
    }
}
