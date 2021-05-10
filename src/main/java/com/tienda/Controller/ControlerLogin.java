package com.tienda.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.Productos;
import com.tienda.modelo.Usuarios;
import com.tienda.services.LoginServices;
import com.tienda.services.ProductoServices;

import javassist.expr.NewArray;

@Controller
@RequestMapping("/tienda")
public class ControlerLogin {
	@Autowired
	public LoginServices loginServices;
	@Autowired
	public ProductoServices productosServices;

	@GetMapping("/login")
	public String getLoginPrincipal(Model model) {

		model.addAttribute("usuario", new Usuarios());

		return "login";
	}

	@GetMapping("/menuPrincipal")
	public String getStringLoginPrincipal(Model model) {
		model.addAttribute("usuario", new Usuarios());
		Iterable<Productos> listaProductos = productosServices.buscarProductos();
		model.addAttribute("listaProductos", listaProductos);
		return "menuPrincipal";
	}
	
	
	@PostMapping("/menuPrincipal")
	public String postLoginPrincipal(Model model, @ModelAttribute Usuarios u,HttpSession session) {
		
		Usuarios uexiste = loginServices.buscarUsuarioEmail(u.getEmail());

		if (uexiste != null) {
			Iterable<Productos> listaProductos = productosServices.buscarProductos();
			session.setAttribute("usuario", u.getNombre());
			model.addAttribute("usuario", uexiste.getNombre());
			model.addAttribute("listaProductos", listaProductos);
			return "menuPrincipal";

		} else {

			return "login";
		}

	}
	
	@GetMapping("/logout")
	public String getStringLogout(Model model,HttpSession session) {
		session.invalidate();
		return "redirect:/tienda/menuPrincipal";
	}





}
