package com.service.examen.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Agrege un username")
    private String username;

    @NotEmpty(message = "Agrege una contraseña")
    private String password;

    @NotEmpty(message = "Agrege un nombre")
    private String nombre;

    private String apellido;

    @NotEmpty(message = "Agregue un correo")
    @Email(message = "No es un correo valido")
    private String email;

    private String telefono;

    private boolean enabled=true;

    private String perfil;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "usuario")
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();
}
