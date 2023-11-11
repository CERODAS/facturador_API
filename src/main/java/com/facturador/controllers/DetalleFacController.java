package com.facturador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturador.dao.IDaoDetalleFac;
import com.facturador.entity.DetalleFac;

@RestController
@RequestMapping(value = "/api/detalle")
public class DetalleFacController {
	@Autowired
	public IDaoDetalleFac daoDetalleFac;
	
	@GetMapping(value = "/consultarDetalle", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DetalleFac> listarDetalle(){
		return daoDetalleFac.listarDetalle();
	}
	
	@PostMapping(value = "/agregarDetalle", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public DetalleFac agregarDetalle(@RequestBody DetalleFac df) {
		return daoDetalleFac.insertar(df);
	}
}
