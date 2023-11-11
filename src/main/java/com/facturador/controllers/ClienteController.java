package com.facturador.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/cliente")
public class ClienteController {
	@Autowired
	public IDaoCliente daoCliente;
	
	@GetMapping(value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> listarClientes(){
		return daoCliente.listadoCliente(1);
	}
	
	@GetMapping(value = "/consultar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cliente listadoPorId(@PathVariable int id) {
		return daoCliente.listarPorId(id);
	}
	
	@PostMapping(value = "/enviar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente crearCliente(@RequestBody Cliente cliente) {
		return daoCliente.crear(cliente);
	}
	
	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente actualizarCliente(@RequestBody Cliente cliente) {
		return daoCliente.actualizar(cliente);
	}
	
	@PutMapping(value = "/borrar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cliente eliminarCliente(@PathVariable int id) {
		return daoCliente.eliminar(id);
	}
	
	@GetMapping(value = "/buscarNit/{nit}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> buscarPorNit(@PathVariable String nit) {
	    Cliente cliente = daoCliente.buscarPorNit(nit);

	    if (cliente != null) {
	        Map<String, String> respuesta = new HashMap<>();
	        respuesta.put("nombre", cliente.getNombre());
	        respuesta.put("nit", cliente.getNit());
	        return ResponseEntity.ok(respuesta);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

}
