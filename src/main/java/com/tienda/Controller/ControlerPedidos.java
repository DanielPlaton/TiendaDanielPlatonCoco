package com.tienda.Controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tienda.modelo.DetallePedido;
import com.tienda.modelo.Pedidos;
import com.tienda.modelo.Productos;
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
	
	
	@GetMapping("/vertodoslospedidos")
	public String getListaTotalPedidos(Model model, HttpSession session) {
		Usuarios u = (Usuarios) session.getAttribute("usuario");
		Iterable<Pedidos> listaPedidos = pedidosServices.obtenerPedidos();
		model.addAttribute("listaPedidos", listaPedidos);

		return "pedidos/verpedidosempleados";
	}
	
	@GetMapping("/vertodoslospedidosadmin")
	public String getListaTotalPedidosAdmin(Model model, HttpSession session) {
		Usuarios u = (Usuarios) session.getAttribute("usuario");
		Iterable<Pedidos> listaPedidos = pedidosServices.obtenerPedidos();
		model.addAttribute("listaPedidos", listaPedidos);

		return "pedidos/verpedidosadministrador";
	}

	@GetMapping("/verpedidosclientes")
	public String getListaPedidosCliente(Model model, HttpSession session) {
		Usuarios u = (Usuarios) session.getAttribute("usuario");
		Iterable<Pedidos> listaPedidos = pedidosServices.obtenerPedidosIdUsuario(u.getId());
		model.addAttribute("listaPedidos", listaPedidos);

		return "pedidos/verpedidosclientes";
	}

	@GetMapping("/verpedidos")
	public String getListaPedidos(Model model, HttpSession session) {
		Usuarios u = (Usuarios) session.getAttribute("usuario");
		Iterable<Pedidos> listaPedidosPendientes = pedidosServices.obtenerPedidosPendientes("pendiente");
		model.addAttribute("listaPedidos", listaPedidosPendientes);

		return "pedidos/verpedidosempleados";
	}

	@GetMapping("/cancelar/pedidos/{id}")
	public String cancelarPedido(Model model, @PathVariable("id") long id) {

		Pedidos pedidoObtenido = pedidosServices.obtenerPedido(id);
		pedidoObtenido.setEstado("pendiente cancelacion");
		pedidosServices.guardarPedido(pedidoObtenido);
		return "redirect:/tienda/pedidos/verpedidosclientes";
	}

	@GetMapping("/cancelaradmin/pedido/{id}")
	public String cancelarPedidoAdmin(Model model, @PathVariable("id") long id) {

		Pedidos pedidoObtenido = pedidosServices.obtenerPedido(id);
		pedidoObtenido.setEstado("cancelado");
		pedidosServices.guardarPedido(pedidoObtenido);
		return "redirect:/tienda/pedidos/vertodoslospedidosadmin";
	}
	@GetMapping("/validar/pedidos/{id}")
	public String validarPedido(Model model, @PathVariable("id") long id) {

		Pedidos pedidoObtenido = pedidosServices.obtenerPedido(id);

		pedidoObtenido.setEstado("enviado");
		Date fecha = new Date();
		long numFac = fecha.getTime();
		ArrayList<Pedidos> listaPedidos= pedidosServices.obtenerPedidos();
		pedidoObtenido.setNumFactura(String.valueOf(numFac));

		// renombramos el estado del pedido

		pedidosServices.guardarPedido(pedidoObtenido);

		return "redirect:/tienda/pedidos/verpedidosclientes";
	}

	@GetMapping("/verdetallepedidosclientes/{id}")
	public String verListaDetallePedidos(@PathVariable("id") long id, Model model, HttpSession session) {
		Usuarios u = (Usuarios) session.getAttribute("usuario");
		ArrayList<DetallePedido> listaDetallesDelPedidos = detallePedidosServices.obtenerDetallePedido(id);
		model.addAttribute("listaDetallePedidos", listaDetallesDelPedidos);

		return "pedidos/verdetallespedidosclientes";
	}



}
