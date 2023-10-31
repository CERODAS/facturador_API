package com.facturador.dao;

import java.util.List;
import com.facturador.entity.Venta;

public interface IDaoVenta {
	
    List<Venta> listarVentas();
    Venta obtenerVentaPorId(int id);
    Venta crearVenta(Venta venta);
    Venta actualizarVenta(Venta venta);
}