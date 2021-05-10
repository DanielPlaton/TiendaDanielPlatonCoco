package com.tienda.repository;

import org.springframework.data.repository.CrudRepository;


import com.tienda.modelo.Usuarios;


public interface UsuarioRepository  extends CrudRepository<Usuarios, Long>{

	
	Usuarios findById(long id);
	Usuarios findByNombre(String nombre);
}
