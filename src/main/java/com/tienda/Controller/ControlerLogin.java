package com.tienda.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.Productos;
import com.tienda.modelo.Usuarios;

import javassist.expr.NewArray;




@Controller
@RequestMapping("/tienda")
public class ControlerLogin {

	
	@GetMapping("/login")
	public String getLoginPrincipal(Model model) {
		
		model.addAttribute("usuario", new Usuarios());
		
		return "login";
	}
	
	@PostMapping("/menuPrincipal")
	public String postLoginPrincipal(Model model,@ModelAttribute Usuarios u) {
		
		Productos p = new Productos();
		p.setId(1);
		p.setCategorias(1);
		p.setNombre("");
		p.setDescripcion("");
		p.setPrecio(10);
		p.setStock(2);
		p.setImpuesto(20);
		p.setFecha_alta(null);
		p.setFecha_baja(null);
		ArrayList<Productos> list = new ArrayList<>();
		list.add(p);
		model.addAttribute("listaProductos", list);
		model.addAttribute("usuario", u);
		
		return "menuPrincipal";
	}
	
	
}
