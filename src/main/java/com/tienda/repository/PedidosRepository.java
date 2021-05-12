package com.tienda.repository;

import org.springframework.data.repository.CrudRepository;

import com.tienda.modelo.Pedidos;


public interface PedidosRepository  extends CrudRepository<Pedidos, Long>  {

}
