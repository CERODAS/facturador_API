package com.facturador.dao;

import java.util.List;

import com.facturador.entity.Cliente;

public interface IDaoCliente {
	public List<Cliente> listadoCliente(int estado);
	public Cliente listarPorId(int id);
	public Cliente crear(Cliente cliente);
	public Cliente actualizar(Cliente cliente);
	public Cliente eliminar(int id);
	public Cliente buscarPorNit(String nit);
}
