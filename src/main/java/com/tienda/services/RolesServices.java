package com.tienda.services;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.MyLogger;
import com.tienda.modelo.Roles;
import com.tienda.repository.CategoriasRepository;
import com.tienda.repository.RolesRepository;


@Service
public class RolesServices {
	
	public static Logger logger = MyLogger.crearLogger(RolesServices.class);
	@Autowired
	private RolesRepository rolesRepository;
	
	public ArrayList<Roles> buscarRoles(){
		ArrayList<Roles> listaRoles = (ArrayList<Roles>) rolesRepository.findAll();
		logger.info("Obteniendo lista roles  ");
		return listaRoles;		
	}
}
