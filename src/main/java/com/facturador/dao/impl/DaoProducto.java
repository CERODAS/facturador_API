package com.facturador.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.dao.IDaoProducto;
import com.facturador.entity.Producto;

@Repository
@Transactional


public class DaoProducto implements IDaoProducto{
	@PersistenceContext
	public EntityManager em;

	@Override
	public List<Producto> listadoProducto() {
		try {
			List<Producto> listado=em.createQuery("FROM Producto", Producto.class).getResultList();
					return listado;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Producto ListarId(int id) {
		try {
			Producto producto =em.find(Producto.class,id);
			return producto;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Producto crear(Producto producto) {
		try {
			em.persist(producto);
			return producto;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Producto actualizar(Producto producto) {
		try {
			em.merge(producto);
			return producto;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	

}
