package com.tienda.services;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.MyLogger;
import com.tienda.modelo.Pedidos;

import com.tienda.repository.PedidosRepository;


@Service
public class PedidosServices {

	public static Logger logger = MyLogger.crearLogger(PedidosServices.class);
	@Autowired
	private PedidosRepository pedidosRepository;
	
	  public ArrayList<Pedidos> obtenerPedidos() {
		  ArrayList<Pedidos> listaPedidos =  pedidosRepository.findAll();
		  logger.info("Obteniendo lista pedidos  "+listaPedidos.toString());
	        return listaPedidos;
	    }
	  
	  public ArrayList<Pedidos> obtenerPedidosIdUsuario(long id) {
		  ArrayList<Pedidos> listaPedidosUsuario = pedidosRepository.findByUsuarios(id);
		  logger.info("Obteniendo lista pedidos de un usuario "+listaPedidosUsuario.toString());
	        return listaPedidosUsuario;
	    }
	  public ArrayList<Pedidos> obtenerPedidosPendientes(String estado) {
		  ArrayList<Pedidos> listaPedidosPorEstados = pedidosRepository.findByEstado(estado);
		  logger.info("Obteniendo lista pedidos de un usuario "+listaPedidosPorEstados.toString());
	        return listaPedidosPorEstados;
	    }
	  
		public Pedidos guardarPedido(Pedidos pedido) {
			
			 logger.info("guardando pedidos");
			return pedidosRepository.save(pedido);
			
			
		}
		
		public Pedidos obtenerPedido(long id) {
			logger.info("obteniendo pedido "+id);
			Pedidos p = pedidosRepository.findById(id);
			return p;
			
		}
}
