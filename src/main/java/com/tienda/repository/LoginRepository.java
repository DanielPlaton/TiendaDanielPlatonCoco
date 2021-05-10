package com.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import com.tienda.modelo.Usuarios;

public interface LoginRepository extends CrudRepository<Usuarios, Long> {

	
	//necesitamos esto para buscar por id el usuario y que no te de un generico
	Usuarios findById(long id);
	Usuarios findByEmail(String email);
	Usuarios findByEmailAndClave(String email,String Clave);
	
}
