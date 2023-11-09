package com.facturador.dao;

import java.util.List;

import com.facturador.entity.Categoria;

public interface IDaoCategoria {
	public List<Categoria> listadoCategoria(int estado);
	public Categoria listarPorId(int id);
	public Categoria crear(Categoria caregoria);
	public Categoria actualizar(Categoria categoria);
	public Categoria eliminar(int id);

}
