package com.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import com.tienda.modelo.Usuarios;

public interface LoginRepository extends CrudRepository<Usuarios, Long> {

	
	//necesitamos esto para buscar por id el contacto y no te de un generico
	Usuarios findById(long id);
	Usuarios findByNombre(String nombre);
}
