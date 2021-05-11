package com.tienda.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.standard.expression.Each;

import com.tienda.modelo.Productos;

import com.tienda.services.ProductoServices;

@Controller
@RequestMapping("/tienda/productos")
public class ControlerProductos {

	@Autowired
	public ProductoServices productoServices;

	@GetMapping("/verproducto/{id}")
	public String getStringverProducto(@PathVariable("id") long id, Model model, HttpSession session) {
		Productos producto = productoServices.obtenerProducto(id);
		model.addAttribute("producto", producto);
		return "/productos/verproducto";
	}

	@GetMapping("/verproductos")
	public String getStringverProductos(Model model, HttpSession session) {
		Iterable<Productos> listaProductos = productoServices.buscarProductos();
		model.addAttribute("listaProductos", listaProductos);
		return "productos/verproductos";
	}

	@GetMapping("/del/productos/{id}")
	public String borrarProducto(Model model, @PathVariable("id") long id, HttpSession session) {

		ArrayList<Productos> carrito = (ArrayList<Productos>) session.getAttribute("carrito");
		Productos p = productoServices.obtenerProducto(id);
		
		carrito.remove(p);

		return "redirect:/tienda/productos/verproductos";
	}
	
	
	
	
	
	
	
	@GetMapping("/putProducto/{id}")
	public String getStringPutProductoCarrito(@PathVariable("id") long id, Model model, HttpSession session) {
		Productos producto = productoServices.obtenerProducto(id);
		ArrayList<Productos> carrito = (ArrayList<Productos>) session.getAttribute("carrito");
		carrito.add(producto);
		session.setAttribute("carrito", carrito);
		return "redirect:/tienda/menuPrincipal";
	}


	@GetMapping("/carrito")
	public String listaProductosCarrito(HttpSession session) {
		session.getAttribute("carrito");
		return "productos/productos";

	}

	@GetMapping("/del/carrito/{id}")
	public String borrarProductoCarrito(Model model, @PathVariable("id") long id, HttpSession session) {

		ArrayList<Productos> carrito = (ArrayList<Productos>) session.getAttribute("carrito");
		Productos p = productoServices.obtenerProducto(id);
		System.out.println("hola");
		int contador=0;
		for (int i=0;i< carrito.size();i++) {
			
			if(carrito.get(i).getId()==p.getId() && contador==0) {
				carrito.remove(i);
				contador++;
			}
		}
	
		session.setAttribute("carrito", carrito);

		return "redirect:/tienda/productos/carrito";
	}

}
