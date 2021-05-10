package com.tienda.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.Categoria;
import com.tienda.repository.CategoriasRepository;




@Service
public class CategoriasServices {

	@Autowired
	private CategoriasRepository categoriasRepository;
	
	public ArrayList<Categoria> buscarCategorias(){
		ArrayList<Categoria> listaCategorias = (ArrayList<Categoria>) categoriasRepository.findAll();
		return listaCategorias;		
	}
}
