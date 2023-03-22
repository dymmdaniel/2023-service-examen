package com.service.examen.controller;

import com.service.examen.model.Order;
import com.service.examen.model.Rol;
import com.service.examen.model.Usuario;
import com.service.examen.model.UsuarioRol;
<<<<<<< Updated upstream
import com.service.examen.service.RolService;
=======
import com.service.examen.service.OrderService;
>>>>>>> Stashed changes
import com.service.examen.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("/usuario")
@Slf4j
//@CrossOrigin("*")Recibir cualquier tipo de peticiones
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
<<<<<<< Updated upstream
    private RolService rolService;
=======
    private OrderService orderService;
>>>>>>> Stashed changes

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

    @PostMapping("/mlf")
    public ResponseEntity<?> pruebaMLF(@RequestHeader("Authorization") String auth,@RequestBody Object obj){
        log.info(auth);
        log.info(obj.toString());
        //orderService.guardarOrden(orden)
        String body=obj.toString();
        Order orden=new Order();
        orden.setWhId(body.substring(body.indexOf("WH_ID")+1+"WH_ID".length(),body.indexOf("CLIENT_ID")-2));
        orden.setClientId(body.substring(body.indexOf("CLIENT_ID")+1+"CLIENT_ID".length(),body.indexOf("STCUST")-2));
        orden.setStcust(body.substring(body.indexOf("STCUST")+1+"STCUST".length(),body.indexOf("ORDNUM")-2));
        orden.setOrdnum(body.substring(body.indexOf("ORDNUM")+1+"ORDNUM".length(),body.indexOf("ORDTYP")-2));
        orden.setOrdtyp(body.substring(body.indexOf("ORDTYP")+1+"ORDTYP".length(),body.indexOf("RTCUST")-2));
        orden.setRtcust(body.substring(body.indexOf("RTCUST")+1+"RTCUST".length(),body.indexOf("BTCUST")-2));
        orden.setBtcust(body.substring(body.indexOf("BTCUST")+1+"BTCUST".length(),body.length()-3));
        return ResponseEntity.status(HttpStatus.OK).body(orderService.guardarOrden(orden));
    }

    @GetMapping("/mlf/{id}")
    public ResponseEntity<?> listarMLF(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.buscarOrden(id));
    }
}
