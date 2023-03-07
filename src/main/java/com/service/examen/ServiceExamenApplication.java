package com.service.examen;

import com.service.examen.model.Rol;
import com.service.examen.model.Usuario;
import com.service.examen.model.UsuarioRol;
import com.service.examen.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ServiceExamenApplication{

	@Autowired
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(ServiceExamenApplication.class, args);
	}


	/*@Override
	public void run(String... args) throws Exception{
		Usuario usuario = new Usuario();
		usuario.setUsername("DMURILLO");
		usuario.setNombre("Daniel");
		usuario.setApellido("Murillo");
		usuario.setPassword("12345");
		usuario.setEmail("d1@gmail.com");
		usuario.setTelefono("3223008503");
		usuario.setPerfil("foto.png");

		Rol rol = new Rol();
		rol.setRolId(1l);
		rol.setNombre("ROLE_ADMIN");

		Set<UsuarioRol> usuarioRoles = new HashSet<>();
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		usuarioRoles.add(usuarioRol);

		Usuario usuarioTemp= usuarioService.guardarUsuario(usuario,usuarioRoles);
		System.out.println(usuarioTemp.toString());
	}*/
}
