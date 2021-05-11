package com.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import com.tienda.modelo.Categoria;



public interface CategoriasRepository extends CrudRepository<Categoria, Long> {

	Categoria findById(long id);
}
