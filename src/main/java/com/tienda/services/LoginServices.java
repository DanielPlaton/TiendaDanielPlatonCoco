package com.tienda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.Usuarios;
import com.tienda.repository.LoginRepository;
import com.tienda.repository.ProductosRepository;

@Service
public class LoginServices {

	@Autowired
	private LoginRepository loginRepository;

	public Usuarios buscarUsuarioId(int idUsuario) {
		return loginRepository.findById(idUsuario);

	}

	public Usuarios buscarUsuarioEmail(String email) {
		Usuarios u = loginRepository.findByEmail(email);
		return u;

	}

}
