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
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	public int id_cliente;
	public String nombre;
	public String dpi;
	public String telefono;
	public String direccion;
	public String nit;
	public String fecha_creacion;
	public String usuario_creacion;
	public String fecha_mod;
	public String usuario_mod;
	public Boolean estado;
}
