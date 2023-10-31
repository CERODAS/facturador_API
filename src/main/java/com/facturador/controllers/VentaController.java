package com.facturador.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.facturador.dao.IDaoVenta;
import com.facturador.entity.Venta;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    @Autowired
    private IDaoVenta daoVenta;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Venta> listarVentas() {
        return daoVenta.listarVentas();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Venta obtenerVentaPorId(@PathVariable int id) {
        return daoVenta.obtenerVentaPorId(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Venta crearVenta(@RequestBody Venta venta) {
        return daoVenta.crearVenta(venta);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Venta actualizarVenta(@RequestBody Venta venta) {
        return daoVenta.actualizarVenta(venta);
    }
}
