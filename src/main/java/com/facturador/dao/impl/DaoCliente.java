package com.facturador.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
	public List<Cliente> listadoCliente(int estado) {
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
	        CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
	        Root<Cliente> root = criteria.from(Cliente.class);

	        criteria.select(root)
	                .where(builder.equal(root.get("estado"), estado));

	        return em.createQuery(criteria).getResultList();
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

	@Override
	public Cliente eliminar(int id) {
		try {
			Cliente cliente = em.find(Cliente.class, id);
			
			if(cliente != null) {
				cliente.setEstado(false);
				em.merge(cliente);
			}
			return cliente;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
