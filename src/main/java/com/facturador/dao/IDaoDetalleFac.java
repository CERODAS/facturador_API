package com.facturador.dao;

import java.util.List;

import com.facturador.entity.DetalleFac;

public interface IDaoDetalleFac {
	public List<DetalleFac> listarDetalle();
	public DetalleFac insertar(DetalleFac df);
}
