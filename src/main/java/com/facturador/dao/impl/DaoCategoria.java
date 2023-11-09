package com.facturador.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.dao.IDaoCategoria;
import com.facturador.entity.Categoria;
import com.facturador.entity.Cliente;


@Repository
@Transactional

public class DaoCategoria  implements IDaoCategoria{
	@PersistenceContext
	public EntityManager em;

	@Override
	public List<Categoria> listadoCategoria(int estado) {
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
	        CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
	        Root<Categoria> root = criteria.from(Categoria.class);

	        criteria.select(root)
	                .where(builder.equal(root.get("estado"), estado));

	        return em.createQuery(criteria).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Categoria listarPorId(int id) {
		try {
			Categoria categoria =em.find(Categoria.class, id);
			return categoria;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Categoria crear(Categoria caregoria) {
		try {
			em.persist(caregoria);
			return caregoria;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Categoria actualizar(Categoria categoria) {
		try {
			em.merge(categoria);
			return categoria;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	@Override
	public Categoria eliminar(int id) {
		try {
			Categoria categoria= em.find(Categoria.class, id);
			
			if(categoria != null) {
				categoria.setEstado(false);
				em.merge(categoria);
			}
			return categoria;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}



}
