package com.facturador.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "factura")
public class factura {
	@Id
    @Column(name = "id_factura")
	public String id_factura;
	public int fk_cliente;
	public Date fecha;
	public Date fecha_creacion;
	public String usuario_creacion;
	public Date fecha_mod;
	public String usuario_mod;
	public boolean estado;
}
