package com.tienda.services;

import java.util.ArrayList;

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
	
	  public ArrayList<Pedidos> obtenerPedidos() {
	        return pedidosRepository.findAll();
	    }
	  
	  public ArrayList<Pedidos> obtenerPedidosIdUsuario(long id) {
	        return pedidosRepository.findByUsuarios(id);
	    }
	  
		public Pedidos guardarPedido(Pedidos pedido) {
			return pedidosRepository.save(pedido);
			
			
		}
		
		public Pedidos obtenerPedido(long id) {
			return pedidosRepository.findById(id);
			
		}
}
