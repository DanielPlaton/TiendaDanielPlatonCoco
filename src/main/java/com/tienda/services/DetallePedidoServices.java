package com.tienda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.DetallePedido;
import com.tienda.modelo.Pedidos;
import com.tienda.repository.DetallePedidosRepository;
import com.tienda.repository.PedidosRepository;

@Service
public class DetallePedidoServices {

	@Autowired
	private DetallePedidosRepository detalePedidosRepository;
	
	  public DetallePedido obtenerDetallePedidos() {
	        return (DetallePedido) detalePedidosRepository.findAll();
	    }
	  
		public void guardarDetallePedido(DetallePedido detallePedido) {
			detalePedidosRepository.save(detallePedido);
			
		}
}
