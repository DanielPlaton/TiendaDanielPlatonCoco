package com.tienda.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.Usuarios;
import com.tienda.repository.UsuarioRepository;




@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public ArrayList<Usuarios> buscarUsuarios(){
		ArrayList<Usuarios> listaUsuarios = (ArrayList<Usuarios>) usuarioRepository.findAll();
		return listaUsuarios;		
	}
	
	  public Usuarios obtenerUsuario(long id) {
	        return usuarioRepository.findById(id);
	    }
	  
	  public void guardarUsuario(Usuarios usuario) {
	        usuarioRepository.save(usuario);
	    }
	  public void deleteUsuario(long id) {
	    	usuarioRepository.deleteById(id);
	    }
}
