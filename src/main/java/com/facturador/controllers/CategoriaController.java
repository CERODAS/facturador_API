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

import com.facturador.dao.IDaoCategoria;
import com.facturador.entity.Categoria;

@RestController
@RequestMapping (value ="/api")

public class CategoriaController {

	@Autowired
	public IDaoCategoria daoCategoria;
	
	@GetMapping (value ="/categoria",produces =MediaType.APPLICATION_JSON_VALUE)
	public List<Categoria> listarCategoria(){
		return daoCategoria.listadoCategoria();
	}
	
	@GetMapping (value ="/categoria/{id}",produces =MediaType.APPLICATION_JSON_VALUE)
	public Categoria listarId(@PathVariable int id){
		return daoCategoria.listarPorId(id);
	}
	
	@PostMapping (value ="categoria",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Categoria crearCategoria(@RequestBody Categoria categoria) {
		return daoCategoria.crear(categoria);
	}
	
	@PutMapping (value="/categoria",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Categoria actualizaCategoria (@RequestBody Categoria categoria) {
		return daoCategoria.actualizar(categoria);
	}
	
	
}
