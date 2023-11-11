package com.facturador.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.dao.IDaoDetalleFac;
import com.facturador.entity.DetalleFac;

@Repository
@Transactional
public class DaoDetalleFac implements IDaoDetalleFac{
	@PersistenceContext
	public EntityManager em;
	@Override
	public List<DetalleFac> listarDetalle() {
		try {
			List<DetalleFac> listado = em.createQuery("FROM DetalleFac", DetalleFac.class).getResultList();
			return listado;
		}catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	@Override
	public DetalleFac insertar(DetalleFac df) {
		try {
			em.persist(df);
			return df;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
