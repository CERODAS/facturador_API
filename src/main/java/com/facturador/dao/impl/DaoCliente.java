package com.facturador.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.dao.IDaoCliente;
import com.facturador.entity.Cliente;

@Repository
@Transactional
public class DaoCliente implements IDaoCliente{
	@PersistenceContext
	public EntityManager em;
	@Override
	public List<Cliente> listadoCliente() {
		try {
			List<Cliente> listado = em.createQuery("FROM Cliente", Cliente.class).getResultList();
			return listado;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Cliente listarPorId(int id) {
		try {
			Cliente cliente = em.find(Cliente.class, id);
			return cliente;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Cliente crear(Cliente cliente) {
		try {
			em.persist(cliente);
			return cliente;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Cliente actualizar(Cliente cliente) {
		try {
			em.merge(cliente);
			return cliente;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
