package com.service.examen.controller;

import com.service.examen.model.Rol;
import com.service.examen.model.Usuario;
import com.service.examen.model.UsuarioRol;
import com.service.examen.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/")
    public ResponseEntity<?> guardarUsuario(@RequestBody Usuario usuario) throws  Exception{
        Set<UsuarioRol> roles = new HashSet<>();
        Rol rol = new Rol();
        rol.setRolId(2l);
        rol.setNombre("ROLE_USUARIO");

        UsuarioRol usuarioRol= new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardarUsuario(usuario,roles));
    }
    @GetMapping("/{username}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable("username") String username){
        Optional<Usuario> optional=usuarioService.obtenerUsuario(username);
        if(!optional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional);
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/xd")
    public ResponseEntity<?> pruebaMateo(@RequestHeader("Authorization") String value){
        System.out.println("Este es el token: "+value);
        if(value.equals("Basic U1VQRVI6U1VQRVI=")){
            return ResponseEntity.status(HttpStatus.OK).body("Aceptado");
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
