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
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    public int id_venta;
    public float precio;
    public int unidades;
    public Date fechaCreacion;
    public String usuarioCreacion;
    public Date fechaMod;
    public String usuarioMod;
    public boolean estado;
	
}