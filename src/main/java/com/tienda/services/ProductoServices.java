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

	public ArrayList<Productos> buscarProductos() {
		ArrayList<Productos> listaProductos = (ArrayList<Productos>) productosRepository.findAll();
		return listaProductos;

	}

	public Productos obtenerProducto(long id) {
		return productosRepository.findById(id);
	}

	public ArrayList<Productos> obtenerProductosCategorias(long id) {
		return productosRepository.findByCategorias(id);
	}
	
	public boolean existeCarrito(Iterable<Productos> carrito) {
		if (carrito == null) {
			return true;

		}
		return false;

	}
}
