package com.tienda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.Usuarios;
import com.tienda.repository.UsuarioRepository;




@Service
public class UsuarioServices {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Iterable<Usuarios> buscarUsuarios(){
		Iterable<Usuarios> listaUsuarios = usuarioRepository.findAll();
		return listaUsuarios;		
	}
	
	  public Usuarios obtenerUsuario(int id) {
	        return usuarioRepository.findById(id);
	    }
	  
	  public void guardarUsuario(Usuarios usuario) {
	        usuarioRepository.save(usuario);
	    }
}
