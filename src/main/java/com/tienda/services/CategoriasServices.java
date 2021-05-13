package com.tienda.services;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.MyLogger;
import com.tienda.modelo.Categoria;
import com.tienda.repository.CategoriasRepository;

@Service
public class CategoriasServices {

	public static Logger logger = MyLogger.crearLogger(CategoriasServices.class);
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	public ArrayList<Categoria> buscarCategorias(){
		
		ArrayList<Categoria> listaCategorias = (ArrayList<Categoria>) categoriasRepository.findAll();
		logger.info("obteniendo todas las categorias "+listaCategorias.toString());
		return listaCategorias;		
	}
}
