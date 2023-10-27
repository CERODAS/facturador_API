package com.facturador.dao;

import java.util.List;

import com.facturador.entity.Producto;

public interface IDaoProducto {

	public List<Producto> listadoProducto();
	public Producto ListarId(int id);
	public Producto crear (Producto producto);
	public Producto actualizar (Producto producto);
	
}
