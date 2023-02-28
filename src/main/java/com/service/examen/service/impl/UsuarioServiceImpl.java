package com.service.examen.service.impl;


import com.service.examen.model.Usuario;
import com.service.examen.model.UsuarioRol;
import com.service.examen.repository.RolRepository;
import com.service.examen.repository.UsuarioRepository;
import com.service.examen.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception{
        Usuario usuarioTemp = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioTemp != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }
        else{
            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
        }
    }
}
