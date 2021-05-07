package com.tienda.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.Productos;

import com.tienda.repository.ProductosRepository;
@Service
public class ProductoServices {

	@Autowired
	private ProductosRepository productosRepository;
	
	public Iterable<Productos> buscarProductos(){
		Iterable<Productos> listaProductos = productosRepository.findAll();
		return listaProductos;
		
		
	}
}
