package com.facturador.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.dao.IDaoFactura;
import com.facturador.entity.factura;

@Repository
@Transactional
public class DaoFactura implements IDaoFactura {
	@PersistenceContext
	public EntityManager em;
	
	@Override
	public List<factura> listarFactura(int estado) {
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
	        CriteriaQuery<factura> criteria = builder.createQuery(factura.class);
	        Root<factura> root = criteria.from(factura.class);

	        criteria.select(root)
	                .where(builder.equal(root.get("estado"), estado));

	        return em.createQuery(criteria).getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public factura crear(factura fac) {
		try {
			em.persist(fac);
			return fac;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public factura actualizar(factura fac) {
		try {
			em.merge(fac);
			return fac;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
