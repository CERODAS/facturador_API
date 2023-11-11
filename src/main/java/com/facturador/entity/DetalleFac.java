package com.facturador.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "detalle_factura")
@IdClass(DetalleFac.class)
public class DetalleFac implements Serializable {
	@Id
	@Column(name = "id_factura")
	public String idFactura;
	@Id
	@Column(name = "id_producto")
	public int idProducto;
	@Id
	@Column(name = "fecha")
	public String fecha;
	public float precio;
	public int unidades;
	public float total;
}
