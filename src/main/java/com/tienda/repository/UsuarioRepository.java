package com.tienda.repository;

import org.springframework.data.repository.CrudRepository;


import com.tienda.modelo.Usuarios;


public interface UsuarioRepository  extends CrudRepository<Usuarios, Long>{

	
	Usuarios findById(int id);
	Usuarios findByNombre(String nombre);
}
