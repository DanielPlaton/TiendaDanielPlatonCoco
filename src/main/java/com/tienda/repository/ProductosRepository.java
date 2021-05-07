package com.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import com.tienda.modelo.Productos;



public interface ProductosRepository extends CrudRepository<Productos, Long> {

	Productos findById(int id);
	
}
