package com.tienda.services;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.MyLogger;
import com.tienda.modelo.MetodosPago;
import com.tienda.repository.MetodosPagoRepository;

@Service
public class MetodosPagosServices  {
	public static Logger logger = MyLogger.crearLogger(MetodosPago.class);
	@Autowired
	private MetodosPagoRepository metodosPagosRepository;
	
	public ArrayList<MetodosPago> buscarMetodosPago(){
		
		ArrayList<MetodosPago> listaMetodosPago = (ArrayList<MetodosPago>) metodosPagosRepository.findAll();
		logger.info("validando email y clave del usuario "+listaMetodosPago.toString());
		return listaMetodosPago;		
	}
}
