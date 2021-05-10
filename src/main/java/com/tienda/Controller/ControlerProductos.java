package com.tienda.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.Productos;

import com.tienda.services.ProductoServices;


@Controller
@RequestMapping("/tienda/productos")
public class ControlerProductos {

	@Autowired
	public ProductoServices productoServices;
	@GetMapping("/verproducto/{id}")
	public String getStringverProducto(@PathVariable("id")long id,Model model,HttpSession session) {
		Productos producto = productoServices.obtenerProducto(id);
		model.addAttribute("producto", producto);
		return "/productos/verproducto";
	}
	
	@GetMapping("/verproducto")
	public String getStringverProductos(Model model,HttpSession session) {
		Iterable<Productos> listaProductos = productoServices.buscarProductos();
		model.addAttribute("listaProducto", listaProductos);
		return "/productos/verproducto";
	}

}
