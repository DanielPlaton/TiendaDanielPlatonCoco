package com.tienda.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.tienda.modelo.Productos;



public interface ProductosRepository extends CrudRepository<Productos, Long> {

	Productos findById(long id);
	ArrayList<Productos> findByCategorias(long id);

	
}
