package com.tienda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.Pedidos;
import com.tienda.modelo.Productos;
import com.tienda.modelo.Usuarios;
import com.tienda.repository.PedidosRepository;
import com.tienda.repository.ProductosRepository;

@Service
public class PedidosServices {

	@Autowired
	private PedidosRepository pedidosRepository;
	
	  public Pedidos obtenerPedidos() {
	        return (Pedidos) pedidosRepository.findAll();
	    }
	  
		public Pedidos guardarPedido(Pedidos pedido) {
			return pedidosRepository.save(pedido);
			
			
		}
}
