package com.tienda.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.Roles;
import com.tienda.repository.CategoriasRepository;
import com.tienda.repository.RolesRepository;


@Service
public class RolesServices {
	@Autowired
	private RolesRepository rolesRepository;
	
	public ArrayList<Roles> buscarRoles(){
		ArrayList<Roles> listaRoles = (ArrayList<Roles>) rolesRepository.findAll();
		return listaRoles;		
	}
}
