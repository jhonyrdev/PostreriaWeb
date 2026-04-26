package com.postreria.server.Modules.clientes.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CLIENTES")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @Column(name="CORREO", length = 50, nullable = false, unique = true)
    private String correo;

    @Column(name="CONTRASENA", length = 255, nullable = false)
    private String contrasena;

    @Column(name="NOMBRE", length = 50, nullable = false)
    private String nombre;

    @Column(name="APELLIDO", length = 50, nullable = false)
    private String apellido;

    @Column(name="TOKEN_LOGIN")
    private String tokenLogin;

    @Column(name="TOKEN_LOGIN_EXPIRA")
    private LocalDateTime tokenLoginExpira;

    @Column(name="TOKEN_RECUPERAR")
    private String tokenRecuperar;

    @Column(name="TOKEN_RECUPERAR_EXPIRA")
    private LocalDateTime tokenRecuperarExpira;

    


}
