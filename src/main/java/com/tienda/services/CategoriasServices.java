package com.tienda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.Categoria;
import com.tienda.repository.CategoriasRepository;




@Service
public class CategoriasServices {

	@Autowired
	private CategoriasRepository categoriasRepository;
	
	public Iterable<Categoria> buscarCategorias(){
		Iterable<Categoria> listaCategorias = categoriasRepository.findAll();
		return listaCategorias;		
	}
}
