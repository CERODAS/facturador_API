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

import com.facturador.dao.IDaoProducto;

import com.facturador.entity.Producto;

@RestController
@RequestMapping (value ="/api")

public class ProductoController {
	@Autowired
	public IDaoProducto daoProducto;
	
	@GetMapping (value="/producto",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> listarProducto(){
		return daoProducto.listadoProducto();
	}
	

	@GetMapping(value = "/producto/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Producto listadoPorId(@PathVariable int id) {
		return daoProducto.ListarId(id);
	}
	
	@PostMapping(value="/producto",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Producto crearProducto (@RequestBody Producto producto) {
		return daoProducto.crear(producto);
	}
	
	@PutMapping(value="/producto",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Producto actualizarProducto(@RequestBody Producto producto ) {
		return daoProducto.actualizar(producto);
	}
	

}
