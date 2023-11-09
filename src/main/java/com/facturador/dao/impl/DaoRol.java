package com.facturador.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.dao.IDaoRol;
import com.facturador.entity.Rol;

@Repository
@Transactional
public class DaoRol implements IDaoRol {
	@PersistenceContext
	public EntityManager em;
	@Override
	public List<Rol> listar() {
		try {
			List<Rol> listado=em.createQuery("FROM Rol", Rol.class).getResultList();
			return listado;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
