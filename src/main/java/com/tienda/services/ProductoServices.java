package com.tienda.services;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

	public void deleteProducto(long id) {
		productosRepository.deleteById(id);
	}

	public void guardarProducto(Productos producto) {
		productosRepository.save(producto);
		
	}
	
	public static Timestamp transformarFecha(String fecha) {

		Timestamp timestamp = null;
		Date d = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			d = formatter.parse(fecha);
			timestamp = new java.sql.Timestamp(d.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		return timestamp;
	}
}
