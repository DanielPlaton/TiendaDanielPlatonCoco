package com.tienda.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.tienda.modelo.Pedidos;


public interface PedidosRepository  extends CrudRepository<Pedidos, Long>  {

	
	ArrayList<Pedidos> findAll();

	ArrayList<Pedidos> findByUsuarios(long id);
	
	Pedidos findById(long id);
}
