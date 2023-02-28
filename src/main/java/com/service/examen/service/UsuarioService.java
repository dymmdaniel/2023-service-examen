package com.service.examen.service;

import com.service.examen.model.Usuario;
import com.service.examen.model.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;
}
