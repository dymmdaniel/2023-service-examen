package com.service.examen.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    @Id
    private Long rolId;

    private String nombre;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "rol")
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

}
