package com.tienda.services;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.MyLogger;
import com.tienda.modelo.Productos;

import com.tienda.repository.ProductosRepository;

@Service
public class ProductoServices {

	public static Logger logger = MyLogger.crearLogger(ProductoServices.class);
	@Autowired
	private ProductosRepository productosRepository;

	public ArrayList<Productos> buscarProductos() {
		ArrayList<Productos> listaProductos = (ArrayList<Productos>) productosRepository.findAll();
		 logger.info("Obteniendo lista producto  "+listaProductos.toString());
		return listaProductos;

	}

	public Productos obtenerProducto(long id) {
		logger.info("Obteniendo producto  "+id);
		return productosRepository.findById(id);
	}

	public ArrayList<Productos> obtenerProductosCategorias(long id) {
		logger.info("Obteniendo producto por categorias "+id);
		return productosRepository.findByCategorias(id);
	}
	
	public void deleteProducto(long id) {
		logger.info("borrando producto "+id);
		productosRepository.deleteById(id);
	}

	public void guardarProducto(Productos producto) {
		logger.info("guardando o actualizando el producto "+producto);
		productosRepository.save(producto);
		
	}
	
	public boolean existeCarrito(Iterable<Productos> carrito) {
		if (carrito == null) {
			return true;

		}
		return false;

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
