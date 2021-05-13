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
	
	public ArrayList<Usuarios> obtenerUsuariosClientes(){
		
		ArrayList<Usuarios> listaUsuarios =  usuarioRepository.findByRoles(3);
		
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
	  
	  public void encriptarClave() {
		  /*
		  Base64 base64 = new Base64();
			String claveEncriptada = new String(base64.encode(parametroClave.getBytes()));
			logger.info("contraseña Encriptada: ");
			u.setClave(claveEncriptada);
			*/
	  }
}
