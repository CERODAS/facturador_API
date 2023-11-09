package com.facturador.dao;

import java.util.List;

import com.facturador.entity.Producto;

public interface IDaoProducto {

	public List<Producto> listadoProducto(int estado);
	public Producto ListarId(int id);
	public Producto crear (Producto producto);
	public Producto actualizar (Producto producto);
	public Producto eliminar(int id);
	
}
