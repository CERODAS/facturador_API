package com.facturador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturador.dao.IDaoFactura;
import com.facturador.entity.factura;

@RestController
@RequestMapping(value = "/api")
public class facturaController {
	@Autowired
	public IDaoFactura daoFactura;
	
	@GetMapping(value = "/factura", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<factura> listarFactura(){
		return daoFactura.listarFactura(1);
	}
	
	@PostMapping(value = "/factura/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public factura insertarFactura(@RequestBody factura fac) {
		return daoFactura.crear(fac);
	}
}
