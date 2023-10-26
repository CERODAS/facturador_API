package com.facturador.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	public int id_usuario;
	public int fk_rol;
	public String usuario;
	public String pass;
	public String nombre;
	public String telefono;
	public String correo;
	public String fecha_creacion;
	public String usuario_creacion;
	public String fecha_mod;
	public String usuario_mod;
	public Boolean estado;
}
