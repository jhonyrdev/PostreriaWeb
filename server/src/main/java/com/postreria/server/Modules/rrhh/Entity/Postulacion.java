package com.postreria.server.Modules.rrhh.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="POSTULACION")
public class Postulacion implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_POSTULANTE")
    private Integer id;
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="APELLIDO")
    private String apellido;
    @Column(name="DNI_PASAPORTE")
    private String dni;
    @Column(name="TELEFONO")
    private String telefono;
    @Column(name = "CORREO_POSTULACION")
    private String correo;
    @Column(name = "DIRECCION")
    private String direccion;
    
}

