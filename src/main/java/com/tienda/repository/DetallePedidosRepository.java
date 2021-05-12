package com.tienda.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.tienda.modelo.DetallePedido;


public interface DetallePedidosRepository extends CrudRepository<DetallePedido, Long> {

	ArrayList<DetallePedido> findByPedidos(long id);
}
