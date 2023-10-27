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
@Table (name ="categorias")
public class Categoria {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column (name ="id_categoria")
	public int id_categoria;
	public String nombre;
	public Date fecha_creacion;
	public String usuario_creacion;
	public Date fecha_mod;
	public String usuario_mod;
	public Boolean estado;


}
