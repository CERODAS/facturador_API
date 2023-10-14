package com.facturador.dao;

import java.util.List;

import com.facturador.entity.Cliente;

public interface IDaoCliente {
	public List<Cliente> listadoCliente();
	public Cliente listarPorId(int id);
	public Cliente crear(Cliente cliente);
	public Cliente actualizar(Cliente cliente);
}
