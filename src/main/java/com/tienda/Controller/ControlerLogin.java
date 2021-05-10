package com.tienda.Controller;

import java.util.ArrayList;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.Categoria;
import com.tienda.modelo.Productos;
import com.tienda.modelo.Usuarios;
import com.tienda.services.CategoriasServices;
import com.tienda.services.LoginServices;
import com.tienda.services.ProductoServices;

import javassist.expr.NewArray;

@Controller
@RequestMapping("/tienda")
public class ControlerLogin {

	ArrayList<Productos> carrito;
	@Autowired
	public LoginServices loginServices;
	@Autowired
	public ProductoServices productosServices;
	@Autowired
	public CategoriasServices categoriasServices;

	@GetMapping("/login")
	public String getLoginPrincipal(Model model) {

		model.addAttribute("usuario", new Usuarios());

		return "login";
	}

	@GetMapping("/menuPrincipal")
	public String getStringLoginPrincipal(Model model, HttpSession session) {
		model.addAttribute("usuario", new Usuarios());

		ArrayList<Productos> listaProductos = productosServices.buscarProductos();
		ArrayList<Categoria> listaCategorias = categoriasServices.buscarCategorias();
		model.addAttribute("listaProductos", listaProductos);
		model.addAttribute("listaCategorias", listaCategorias);
		boolean existe = productosServices.existeCarrito(carrito);
		if (existe == true) {
			carrito = new ArrayList<Productos>();

		}
		Productos p = (Productos) model.getAttribute("producto");
		if (session.getAttribute("usuario") != null && p!= null ) {
			
			carrito.add(p);
		}

		return "menuPrincipal";
	}

	@PostMapping("/menuPrincipal")
	public String postLoginPrincipal(Model model, @ModelAttribute Usuarios u, HttpSession session) {

		Usuarios uexiste = loginServices.buscarUsuarioEmailAndClave(u.getEmail(), u.getClave());

		if (uexiste != null) {

			session.setAttribute("usuario", uexiste);
			session.setAttribute("carrito", carrito);
			model.addAttribute("usuario", uexiste);

			return "redirect:/tienda/menuPrincipal";

		} else {

			return "login";
		}

	}

	@GetMapping("/logout")
	public String getStringLogout(Model model, HttpSession session) {
		session.invalidate();
		carrito = null;
		return "redirect:/tienda/menuPrincipal";
	}

}
