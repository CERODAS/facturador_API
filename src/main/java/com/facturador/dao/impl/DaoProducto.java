package com.facturador.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
	public List<Producto> listadoProducto(int estado) {
		try {
			CriteriaBuilder builder=em.getCriteriaBuilder();
			CriteriaQuery<Producto> criteria= builder.createQuery(Producto.class);
			Root<Producto> root = criteria.from(Producto.class);
			 
			criteria.select(root)
						.where(builder.equal(root.get("estado"),estado));
			return em.createQuery(criteria).getResultList();
			
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



	@Override
	public Producto eliminar(int id) {
		try {
			Producto producto = em.find(Producto.class, id);
			if(producto !=null) {
				producto.setEstado(false);
				em.merge(producto);				
			}
			return producto;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		
	}
	
	

}
