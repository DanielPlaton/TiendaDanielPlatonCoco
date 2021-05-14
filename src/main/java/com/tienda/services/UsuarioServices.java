package com.tienda.services;

import java.util.ArrayList;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.MyLogger;
import com.tienda.modelo.Productos;
import com.tienda.modelo.Usuarios;
import com.tienda.repository.UsuarioRepository;




@Service
public class UsuarioServices {

	public static Logger logger = MyLogger.crearLogger(UsuarioServices.class);
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public ArrayList<Usuarios> buscarUsuarios(){
		ArrayList<Usuarios> listaUsuarios = (ArrayList<Usuarios>) usuarioRepository.findAll();
		 logger.info("Obteniendo lista usuario  "+listaUsuarios.toString());
		return listaUsuarios;		
	}
	
	public ArrayList<Usuarios> obtenerUsuariosClientes(){
		
		ArrayList<Usuarios> listaUsuarios =  usuarioRepository.findByRoles(3);
		 logger.info("Obteniendo lista usuario de clientes "+listaUsuarios.toString());
		return listaUsuarios;
	}
	  public Usuarios obtenerUsuario(long id) {
		  logger.info("Obteniendo  usuario concreto ");
	        return usuarioRepository.findById(id);
	    }
	  
	  public void guardarUsuario(Usuarios usuario) {
		  logger.info("guardando usuario ");
	        usuarioRepository.save(usuario);
	    }
	  public void deleteUsuario(long id) {
		  logger.info("borrando usuario  ");
	    	usuarioRepository.deleteById(id);
	    }
	  
	  public String encriptarClave(String clave) {
		  
		  Base64 base64 = new Base64();
			String claveEncriptada = new String(base64.encode(clave.getBytes()));
			return claveEncriptada;	
			
	  }
		public ArrayList<Usuarios> buscadorNombre(String cadena) {
			ArrayList<Usuarios> listaProductos = (ArrayList<Usuarios>) usuarioRepository.findByNombreContains(cadena);
			 logger.info("Obteniendo lista producto por nombre  "+listaProductos.toString());
			return listaProductos;
		}

}
