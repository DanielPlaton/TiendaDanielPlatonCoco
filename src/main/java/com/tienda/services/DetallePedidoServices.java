package com.tienda.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.DetallePedido;
import com.tienda.modelo.Pedidos;
import com.tienda.repository.DetallePedidosRepository;
import com.tienda.repository.PedidosRepository;

@Service
public class DetallePedidoServices {

	@Autowired
	private DetallePedidosRepository detallePedidosRepository;
	
	  public ArrayList<DetallePedido> obtenerDetallePedidos() {
	        return  (ArrayList<DetallePedido>) detallePedidosRepository.findAll();
	    }
	  
	  
		public void guardarDetallePedido(DetallePedido detallePedido) {
			detallePedidosRepository.save(detallePedido);
			
		}
		
		public  ArrayList<DetallePedido> obtenerDetallePedido(long id) {
			return detallePedidosRepository.findByPedidos(id);
			
		}
		/*
		public void guardarDetallesPedidos(ArrayList<DetallePedido> listaDetallePedido) {
			detallePedidosRepository.saveAll(listaDetallePedido);
			
		}
		*/
}
