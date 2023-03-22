package com.service.examen.controller;

import com.service.examen.model.Rol;
import com.service.examen.model.Usuario;
import com.service.examen.model.UsuarioRol;
import com.service.examen.service.RolService;
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
//@CrossOrigin("*")Recibir cualquier tipo de peticiones
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @PostMapping("/")
    public ResponseEntity<?> guardarUsuario(@RequestBody Usuario usuario) throws  Exception{

        usuario.setPerfil("default.png");
        Rol rol = rolService.buscarRol((long) 2); //ROLE_USER

        Set<UsuarioRol> roles = new HashSet<>();
        UsuarioRol usuarioRol= new UsuarioRol();
        usuarioRol.setRol(rol);
        usuarioRol.setUsuario(usuario);
        roles.add(usuarioRol);

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
    public ResponseEntity<?> pruebaMateo(){
        String value="Basic U1VQRVI6U1VQRVI=";
        System.out.println("Este es el token: ");
        if(value.equals("Basic U1VQRVI6U1VQRVI=")){
            return ResponseEntity.status(HttpStatus.OK).body("Aceptado");
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
