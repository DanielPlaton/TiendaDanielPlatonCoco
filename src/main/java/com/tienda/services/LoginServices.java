package com.tienda.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.MyLogger;
import com.tienda.modelo.Usuarios;
import com.tienda.repository.LoginRepository;
import com.tienda.repository.ProductosRepository;

@Service
public class LoginServices {

	public static Logger logger = MyLogger.crearLogger(LoginServices.class);
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private UsuarioServices usuarioServices;

	public Usuarios buscarUsuarioId(int idUsuario) {
		Usuarios usuario = loginRepository.findById(idUsuario);
		logger.info("obteniendo un usuario en concreto " + usuario.toString());
		return usuario;

	}

	public Usuarios buscarUsuarioEmailAndClave(String email, String clave) {
		Usuarios u = null;
		if (email != null && clave != null) {
			String claveEncriptado = usuarioServices.encriptarClave(clave);

			u = loginRepository.findByEmailAndClave(email, claveEncriptado);
		}
		logger.info("validando email y clave del usuario ");
		return u;

	}

	public Usuarios buscarUsuarioEmail(String email) {
		Usuarios u = loginRepository.findByEmail(email);
		logger.info("obteniendo usuario por el email  " + u.toString());
		return u;

	}
}
