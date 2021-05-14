package com.tienda.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.tienda.modelo.Productos;



public interface ProductosRepository extends CrudRepository<Productos, Long> {

	Productos findById(long id);
	ArrayList<Productos> findByCategorias(long id);
	ArrayList<Productos> findByNombreContains(String cadena);
	ArrayList<Productos> findByPrecioGreaterThan(double cadena);
	ArrayList<Productos> findByPrecioLessThan(double parseDouble);

	
}
