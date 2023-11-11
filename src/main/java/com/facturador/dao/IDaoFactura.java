package com.facturador.dao;

import java.util.List;

import com.facturador.entity.factura;

public interface IDaoFactura {
	public List<factura> listarFactura(int estado);
	public factura crear(factura fac);
	public factura actualizar(factura fac);
}
