package com.facturador.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name ="producto")

public class Producto {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name ="id_producto")
	public int id_producto;
	public String fk_categoria;
	public String nombre;
	public float  costo;
	public int unidades;
	public String fecha_creacion;
	public String usuario_creacion;
	public String fecha_mod;
	public String usuario_mod;
	public Boolean estado;
	

}
