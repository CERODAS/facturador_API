package com.facturador.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.facturador.dao.IDaoVenta;
import com.facturador.entity.Venta;

@Repository
@Transactional
public class DaoVenta implements IDaoVenta {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Venta> listarVentas() {
        try {
            return entityManager.createQuery("FROM Venta", Venta.class).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Venta obtenerVentaPorId(int id) {
        try {
            return entityManager.find(Venta.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Venta crearVenta(Venta venta) {
        try {
            entityManager.persist(venta);
            return venta;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Venta actualizarVenta(Venta venta) {
        try {
            return entityManager.merge(venta);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
