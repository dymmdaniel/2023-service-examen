package com.service.examen.model;

import jakarta.persistence.*;

@Entity
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioRolId;

    @ManyToOne(fetch = FetchType.EAGER) //Muchos a muchos
    private Usuario usuario;

    @ManyToOne  //Muchos a muchos
    private Rol rol;
}
