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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	ArrayList<Productos> listaProductos;
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

	@PostMapping("/menuPrincipal")
	public String postLoginPrincipal(Model model, @ModelAttribute Usuarios u, HttpSession session) {

		Usuarios uexiste = loginServices.buscarUsuarioEmailAndClave(u.getEmail(), u.getClave());

		if (uexiste != null) {

			session.setAttribute("usuario", uexiste);
			model.addAttribute("usuario", uexiste);

			return "redirect:/tienda/menuPrincipal";

		} else {

			return "login";
		}

	}

	@GetMapping("/menuPrincipal")
	public String getStringLoginPrincipal(Model model, HttpSession session) {

		model.addAttribute("usuario", new Usuarios());

		listaProductos = (ArrayList<Productos>) session.getAttribute("listaProductos");
		ArrayList<Categoria> listaCategorias = categoriasServices.buscarCategorias();

		if (listaProductos == null) {
			listaProductos = productosServices.buscarProductos();

		}

		model.addAttribute("listaProductos", listaProductos);
		model.addAttribute("listaCategorias", listaCategorias);

		boolean noexiste = productosServices.existeCarrito(carrito);
		if (noexiste == true) {
			carrito = new ArrayList<Productos>();
			session.setAttribute("carrito", carrito);

		} else {

			session.getAttribute("carrito");
		}

		return "menuPrincipal";
	}

	@GetMapping("/logout")
	public String getStringLogout(Model model, HttpSession session) {
		session.invalidate();
		carrito = null;
		return "redirect:/tienda/menuPrincipal";
	}

	@GetMapping("/busqueda/{id}")
	public String postBusquedaFiltro(@PathVariable("id") long idcategoria, HttpSession session) {
		ArrayList<Productos> productos = productosServices.obtenerProductosCategorias(idcategoria);
		session.setAttribute("listaProductos", productos);
		return "redirect:/tienda/menuPrincipal";

	}

	@GetMapping("/busqueda")
	public String postBusquedaFiltro(HttpSession session) {
		ArrayList<Productos> productos = productosServices.buscarProductos();
		session.setAttribute("listaProductos", productos);
		return "redirect:/tienda/menuPrincipal";

	}

}
