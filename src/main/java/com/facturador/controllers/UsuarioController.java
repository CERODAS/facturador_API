package com.facturador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturador.dao.IDaoUsuario;
import com.facturador.entity.Usuario;

@RestController
@RequestMapping(value = "/api")
public class UsuarioController {
	@Autowired
	public IDaoUsuario daoUsuario;
	
	@GetMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> listarUsuario(){
		return daoUsuario.listadoUsuario();
	}
	
	@GetMapping(value = "/usuario/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Usuario listarPorId(@PathVariable int id) {
		return daoUsuario.listarPorId(id);
	}
	
	@PostMapping(value = "/usuario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		return daoUsuario.crearUsuario(usuario);
	}
	
	@PutMapping(value = "/usuario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario actualizarUsuario(@RequestBody Usuario usuario) {
		return daoUsuario.actualizar(usuario);
	}
}
