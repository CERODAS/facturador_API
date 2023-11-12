package com.facturador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturador.dao.IDaoFactura;
import com.facturador.entity.factura;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/factura")
public class facturaController {
	@Autowired
	public IDaoFactura daoFactura;
	
	@GetMapping(value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<factura> listarFactura(){
		return daoFactura.listarFactura(1);
	}
	
	@PostMapping(value = "/enviar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public factura insertarFactura(@RequestBody factura fac) {
		return daoFactura.crear(fac);
	}
}
