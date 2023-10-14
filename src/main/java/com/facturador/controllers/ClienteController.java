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

import com.facturador.dao.IDaoCliente;
import com.facturador.entity.Cliente;

@RestController
@RequestMapping(value = "/api")
public class ClienteController {
	@Autowired
	public IDaoCliente daoCliente;
	
	@GetMapping(value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> listarClientes(){
		return daoCliente.listadoCliente();
	}
	
	@GetMapping(value = "/cliente/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cliente listadoPorId(@PathVariable int id) {
		return daoCliente.listarPorId(id);
	}
	
	@PostMapping(value = "/cliente", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente crearCliente(@RequestBody Cliente cliente) {
		return daoCliente.crear(cliente);
	}
	
	@PutMapping(value = "/cliente", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente actualizarCliente(@RequestBody Cliente cliente) {
		return daoCliente.actualizar(cliente);
	}
}
