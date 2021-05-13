package com.tienda.services;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.MyLogger;
import com.tienda.modelo.DetallePedido;

import com.tienda.repository.DetallePedidosRepository;

@Service
public class DetallePedidoServices {
	public static Logger logger = MyLogger.crearLogger(DetallePedido.class);
	@Autowired
	private DetallePedidosRepository detallePedidosRepository;
	
	  public ArrayList<DetallePedido> obtenerDetallePedidos() {
		  ArrayList<DetallePedido> listaDetallePedidos =  (ArrayList<DetallePedido>) detallePedidosRepository.findAll();
		  
	        logger.info("obteniendo todos los detalles del pedido "+listaDetallePedidos.toString());
		  
		  return  listaDetallePedidos;
	      
	    }
	  
	  
		public void guardarDetallePedido(DetallePedido detallePedido) {
			detallePedidosRepository.save(detallePedido);
			logger.info("guardando o actualizando el detalle de pedido "+detallePedido.toString());
			
		}
		
		public  ArrayList<DetallePedido> obtenerDetallePedido(long id) {
			
			ArrayList<DetallePedido> listaDetallePedidosConcreto = detallePedidosRepository.findByPedidos(id);
			logger.info("obteniendo el detalle de pedido "+id+"  "+listaDetallePedidosConcreto.toString());
						
			return listaDetallePedidosConcreto;
			
		}

}
