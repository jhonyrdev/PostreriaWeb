package com.postreria.server.Modules.empleados.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="EMPLEADOS")
public class Empleado implements Serializable{
    
    @Id
    @Column(name="EMP_ID")
    private String id;
    @Column(name="EMP_NOM")
    private String nombre;
    @Column(name="EMP_APE")
    private String apellido;
    @Column(name="EMP_DNI")
    private String dni;
    @Column(name="EMP_TEL")
    private String telefono;
    @Column(name="EMP_COR")
    private String correo;
    @Column(name="EMP_DIR")
    private String dirrecion;

    
    
    
    
}
