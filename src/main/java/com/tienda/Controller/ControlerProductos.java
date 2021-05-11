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

import com.tienda.modelo.Categoria;
import com.tienda.modelo.Productos;
import com.tienda.modelo.Roles;
import com.tienda.modelo.Usuarios;
import com.tienda.repository.CategoriasRepository;
import com.tienda.services.CategoriasServices;
import com.tienda.services.ProductoServices;

@Controller
@RequestMapping("/tienda/productos")
public class ControlerProductos {

	// productos
	@Autowired
	public ProductoServices productoServices;
	@Autowired
	public CategoriasServices categoriaServices;

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
	
	@GetMapping("/new/altaproductos")
	public String nuevo(Model model) {
		ArrayList<Categoria> listaCategorias = categoriaServices.buscarCategorias();
		model.addAttribute("listaCategorias", listaCategorias);
		model.addAttribute("producto", new Productos());

		return "productos/altaproductos";
	}

	@PostMapping("/new/altaproductos/submit")
	public String postAltaProductos(Model model, Productos producto) {
		model.addAttribute("producto", producto);
		String fecha = producto.getFecha_baja().toString();
		producto.setFecha_baja(productoServices.transformarFecha(fecha));
		productoServices.guardarProducto(producto);

		return "redirect:/tienda/productos/verproductos";

	}

	@GetMapping("/edit/altaproducto/{id}")
	public String editUsuario(@PathVariable("id") long id, Model model) {
		Productos producto = productoServices.obtenerProducto(id);
		model.addAttribute("producto", producto);
		return "productos/altaproductos";
	}

	@PostMapping("/edit/altaproducto/submit")
	public String submitEditContact(Model model, Productos producto) {
		System.out.println(producto.toString());
		productoServices.guardarProducto(producto);
		
		return "redirect:/tienda/productos/verproductos";
	}

	@GetMapping("/del/productos/{id}")
	public String borrarProducto(Model model, @PathVariable("id") long id, HttpSession session) {

		productoServices.deleteProducto(id);

		return "redirect:/tienda/productos/verproductos";
	}

	// carrito

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
		int contador = 0;
		for (int i = 0; i < carrito.size(); i++) {

			if (carrito.get(i).getId() == p.getId() && contador == 0) {
				carrito.remove(i);
				contador++;
			}
		}

		session.setAttribute("carrito", carrito);

		return "redirect:/tienda/productos/carrito";
	}

}
