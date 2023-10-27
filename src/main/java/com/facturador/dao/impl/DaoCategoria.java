package com.facturador.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.dao.IDaoCategoria;
import com.facturador.entity.Categoria;


@Repository
@Transactional

public class DaoCategoria  implements IDaoCategoria{
	@PersistenceContext
	public EntityManager em;

	@Override
	public List<Categoria> listadoCategoria() {
		try {
			List<Categoria> listado=em.createQuery("FROM Categoria",Categoria.class).getResultList();
			return listado;
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



}
