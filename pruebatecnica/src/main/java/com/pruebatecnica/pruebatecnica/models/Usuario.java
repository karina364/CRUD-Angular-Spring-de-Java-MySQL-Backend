package com.pruebatecnica.pruebatecnica.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="usuarios")
@ToString @EqualsAndHashCode
public class Usuario {

    @Id
    @Getter @Setter @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "identificacion_tipo")
    private String identificacion_tipo;

    @Getter @Setter @Column(name = "identificacion")
    private String identificacion;

    @Getter @Setter @Column(name = "ciudad")
    private String ciudad;

    @Getter @Setter @Column(name = "direccion")
    private String direccion;

    @Getter @Setter @Column(name = "observacion")
    private String observacion;

    @Getter @Setter @Column(name = "telefono")
    private String telefono;

    @Getter @Setter @Column(name = "usuario")
    private String usuario;

    @Getter @Setter @Column(name = "contrasena")
    private String contrasena;

}
