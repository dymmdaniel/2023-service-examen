package com.service.examen.service.impl;


import com.service.examen.model.Usuario;
import com.service.examen.model.UsuarioRol;
import com.service.examen.repository.RolRepository;
import com.service.examen.repository.UsuarioRepository;
import com.service.examen.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception{
        Optional<Usuario> usuarioTemp = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioTemp.isPresent()){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }
        else{
            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioRepository.save(usuario);
        }
        return usuario;
    }

    @Override
    public Optional<Usuario> obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }


}
