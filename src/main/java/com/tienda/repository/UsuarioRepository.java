package com.tienda.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;


import com.tienda.modelo.Usuarios;


public interface UsuarioRepository  extends CrudRepository<Usuarios, Long>{

	
	Usuarios findById(long id);
	Usuarios findByNombre(String nombre);
	ArrayList<Usuarios> findByRoles(long id);
	ArrayList<Usuarios> findByNombreContains(String cadena);
	
}
