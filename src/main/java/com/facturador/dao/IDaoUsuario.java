package com.facturador.dao;

import java.util.List;

import com.facturador.entity.Usuario;

public interface IDaoUsuario {
	public List<Usuario> listadoUsuario();
	public Usuario listarPorId(int id);
	public Usuario crearUsuario(Usuario usuario);
	public Usuario actualizar(Usuario usuario);
}
