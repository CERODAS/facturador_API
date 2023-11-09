package com.facturador.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.facturador.dao.IDaoUsuario;
import com.facturador.entity.Usuario;

@Repository
@Transactional
public class DaoUsuario implements IDaoUsuario {
	@PersistenceContext
	public EntityManager em;

	@Override
	public List<Usuario> listadoUsuario(int estado) {
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
	        CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
	        Root<Usuario> root = criteria.from(Usuario.class);

	        criteria.select(root)
	                .where(builder.equal(root.get("estado"), estado));

	        return em.createQuery(criteria).getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Usuario listarPorId(int id) {
		try {
			Usuario usuario = em.find(Usuario.class, id);
			return usuario;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		try {
			em.persist(usuario);
			return usuario;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Usuario actualizar(Usuario usuario) {
		try {
			em.merge(usuario);
			return usuario;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Usuario eliminar(int id) {
		try {
			Usuario usuario = em.find(Usuario.class, id);
			
			if(usuario != null) {
				usuario.setEstado(false);
				em.merge(usuario);
			}
			return usuario;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
