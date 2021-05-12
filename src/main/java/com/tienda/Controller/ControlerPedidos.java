package com.tienda.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.DetallePedido;
import com.tienda.modelo.Pedidos;
import com.tienda.modelo.Usuarios;
import com.tienda.services.DetallePedidoServices;
import com.tienda.services.PedidosServices;



@Controller
@RequestMapping("/tienda/pedidos")
public class ControlerPedidos {

	@Autowired
	public PedidosServices pedidosServices;
	@Autowired
	public DetallePedidoServices detallePedidosServices;


	@GetMapping("/verpedidosclientes")
	public String getListaPedidos(Model model,HttpSession session) {
		Usuarios u = (Usuarios) session.getAttribute("usuario");
		Iterable<Pedidos> listaPedidos = pedidosServices.obtenerPedidosIdUsuario(u.getId());
		model.addAttribute("listaPedidos", listaPedidos);

		return "pedidos/verpedidosclientes";
	}
	
	@GetMapping("/cancelar/pedidos/{id}")
	public String cancelarPedido(Model model,@PathVariable("id") long id) {
		
		Pedidos pedidoObtenido = pedidosServices.obtenerPedido(id);
		
		pedidoObtenido.setEstado("Cancelado");
		
		//renombramos el estado del pedido
		
		pedidosServices.guardarPedido(pedidoObtenido);
		
		return "redirect:/tienda/pedidos/verpedidosclientes";
	}
	
	
	@GetMapping("/verdetallepedidosclientes/{id}")
	public String verListaDetallePedidos(@PathVariable("id") long id,Model model,HttpSession session) {
		Usuarios u = (Usuarios) session.getAttribute("usuario");
		ArrayList<DetallePedido> listaDetallesDelPedidos =  detallePedidosServices.obtenerDetallePedido(id);
		model.addAttribute("listaDetallePedidos", listaDetallesDelPedidos);
		
		return "pedidos/verdetallespedidosclientes";
	}
	
}
