package com.tienda.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.MetodosPago;
import com.tienda.modelo.Roles;
import com.tienda.repository.MetodosPagoRepository;

@Service
public class MetodosPagosServices  {

	@Autowired
	private MetodosPagoRepository metodosPagosRepository;
	
	public ArrayList<MetodosPago> buscarMetodosPago(){
		ArrayList<MetodosPago> listaMetodosPago = (ArrayList<MetodosPago>) metodosPagosRepository.findAll();
		return listaMetodosPago;		
	}
}
