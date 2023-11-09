package com.facturador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturador.dao.IDaoRol;
import com.facturador.entity.Rol;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class RolController {
	@Autowired
	public IDaoRol daoRol;
	
	@GetMapping(value = "/rol/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Rol> listarRoles(){
		return daoRol.listar();
	}
}
