package com.tienda.Controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.Roles;
import com.tienda.modelo.Usuarios;
import com.tienda.services.RolesServices;
import com.tienda.services.UsuarioServices;

@Controller
@RequestMapping("/tienda/usuarios")
public class ControlerUsuarios {

	@Autowired
	public UsuarioServices usuarioServices;
	@Autowired
	public RolesServices rolesService;

	@GetMapping("/lista")
	public String getListaUsuarios(Model model) {
		Iterable<Usuarios> listaUsuarios = usuarioServices.buscarUsuarios();
		model.addAttribute("listaUsuarios", listaUsuarios);

		return "usuarios/usuarios";
	}

	@GetMapping("/listaclientes")
	public String getListaClientes(Model model) {
		Iterable<Usuarios> listaUsuariosClientes = usuarioServices.obtenerUsuariosClientes();
		model.addAttribute("listaUsuarios", listaUsuariosClientes);

		return "usuarios/usuarios";
	}

	@GetMapping("/new/altausuario")
	public String nuevo(Model model) {
		ArrayList<Roles> listaRoles = rolesService.buscarRoles();
		model.addAttribute("listaRoles", listaRoles);
		model.addAttribute("usuario", new Usuarios());

		return "usuarios/altausuario";
	}

	@GetMapping("/new/usuarionuevo")
	public String nuevoUsuario(Model model) {
		Usuarios u = new Usuarios();
		u.setRoles(3);
		ArrayList<Roles> listaRoles = rolesService.buscarRoles();
		model.addAttribute("listaRoles", listaRoles);
		model.addAttribute("usuario", u);

		return "usuarios/usuarionuevo";
	}

	@PostMapping("/new/altausuario/submit")
	public String postAltaUsuarios(Model model, Usuarios usuario) {

		model.addAttribute("usuario", usuario);

		usuario.setClave(usuarioServices.encriptarClave(usuario.getClave()));
		usuarioServices.guardarUsuario(usuario);

		return "redirect:/tienda/usuarios/lista";

	}

	@PostMapping("/new/usuarionuevo/submit")
	public String postUsuariosnuevo(Model model, Usuarios usuario) {
		model.addAttribute("usuario", usuario);
		usuario.setRoles(3);
		usuario.setClave(usuarioServices.encriptarClave(usuario.getClave()));
		usuarioServices.guardarUsuario(usuario);

		return "redirect:/tienda/login";

	}

	@GetMapping("/edit/altausuario/{id}")
	public String editUsuario(@PathVariable("id") long id, Model model) {

		ArrayList<Roles> listaRoles = rolesService.buscarRoles();
		model.addAttribute("listaRoles", listaRoles);
		Usuarios usuario = usuarioServices.obtenerUsuario(id);
		model.addAttribute("usuario", usuario);
		return "usuarios/altausuario";
	}
	
	@GetMapping("/edit/usuarionuevo/{id}")
	public String editUsuarionuevo(@PathVariable("id") long id, Model model) {

		Usuarios usuario = usuarioServices.obtenerUsuario(id);
		usuario.setRoles(3);
		model.addAttribute("usuario", usuario);
		return "usuarios/usuarionuevo";
	}
	
	@PostMapping("/edit/usuarionuevo/submit")
	public String postEditUsuarionuevo(Model model) {
		
		return "redirect:/tienda/menuPrincipal";
	}

	@PostMapping("/edit/altausuario/submit")
	public String submitEditContact(Model model, @Valid Usuarios usuario) {
		System.out.println(usuario.toString());
		usuario.setClave(usuarioServices.encriptarClave(usuario.getClave()));
		usuarioServices.guardarUsuario(usuario);
	
		return "redirect:/tienda/usuarios/lista";
	}
	
	

	@GetMapping("/del/altausuario/{id}")
	public String borrarUsuario(Model model, @PathVariable("id") long id) {

		usuarioServices.deleteUsuario(id);

		return "redirect:/tienda/usuarios/lista";
	}
}
