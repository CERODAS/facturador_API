package com.facturador.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public List<Usuario> listadoUsuario() {
		try {
			List<Usuario> listado = em.createQuery("FROM Usuario", Usuario.class).getResultList();
			return listado;
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

}
