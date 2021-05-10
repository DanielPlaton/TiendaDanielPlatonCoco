package com.tienda.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.Usuarios;

import com.tienda.services.UsuarioServices;

@Controller
@RequestMapping("/tienda/usuarios")
public class ControlerUsuarios {

	@Autowired
	public UsuarioServices usuarioServices;

	@GetMapping("/lista")
	public String getListaUsuarios(Model model) {
		Iterable<Usuarios> listaUsuarios = usuarioServices.buscarUsuarios();
		model.addAttribute("listaUsuarios", listaUsuarios);

		return "usuarios/usuarios";
	}

	@GetMapping("/new/altausuario")
	public String nuevo(Model model) {
		model.addAttribute("usuario", new Usuarios());

		return "usuarios/altausuario";
	}
	
	@GetMapping("/new/usuarionuevo")
	public String nuevoUsuario(Model model) {
		Usuarios u = new Usuarios();
		u.setRoles(3);
		model.addAttribute("usuario", u);

		return "usuarios/altausuario";
	}

	@PostMapping("/new/altausuario/submit")
	public String postAltaUsuarios(Model model, Usuarios usuario) {
		model.addAttribute("usuario", usuario);
		usuarioServices.guardarUsuario(usuario);
		return "redirect:/tienda/usuarios/lista";
	}

	@GetMapping("/edit/altausuario/{id}")
	public String editUsuario(@PathVariable("id") long id, Model model) {
		Usuarios usuario = usuarioServices.obtenerUsuario(id);
		model.addAttribute("usuario", usuario);
		return "usuarios/altausuario";
	}

	@PostMapping("/edit/altausuario/submit")
	public String submitEditContact(Model model, Usuarios usuario) {
		System.out.println(usuario.toString());
		usuarioServices.guardarUsuario(usuario);
		return "redirect:/tienda/usuarios/lista";
	}

	@GetMapping("/del/altausuario/{id}")
	public String borrarUsuario(Model model,@PathVariable("id") long id) {
		
		usuarioServices.deleteUsuario(id);

		return "redirect:/tienda/usuarios/lista";
	}
}
