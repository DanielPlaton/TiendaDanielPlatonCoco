package com.tienda.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.Productos;
import com.tienda.modelo.Usuarios;
import com.tienda.services.ProductoServices;
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

		return "/usuarios/usuarios";
	}

	@GetMapping("/new/altausuario")
	public String nuevo(Model model) {
		model.addAttribute("usuario", new Usuarios());
		
		return "/usuarios/altausuario";
	}
	@PostMapping("/new/altausuario/submit")
	public String postAltaUsuarios(Model model, Usuarios usuario) {
		model.addAttribute("usuario", usuario);
		return "/usuarios/altausuario";
	}

	@GetMapping("/edit/altausuario/{id}")
	public String editUsuario(@PathVariable("id") int id, Model model) {
		Usuarios usuario = usuarioServices.obtenerUsuario(id);
		model.addAttribute("usuario", usuario);
		return "/usuarios/altausuario";
	}

	@PostMapping("/edit/altausuario/submit")
	public String submitEditContact(Model model,  Usuarios usuario) {
		usuarioServices.guardarUsuario(usuario);
		return "/usuarios/usuarios";
	}
}
