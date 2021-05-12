package com.tienda.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "metodos_pago")
public class MetodosPago {

	@Id
	@Column(name = "id")
	private long id;
	@Column(name = "metodo_pago", nullable = true)
	private String metodoPago;
	
	
	public MetodosPago() {
		super();
	}


	public MetodosPago(long id, String metodoPago) {
		super();
		this.id = id;
		this.metodoPago = metodoPago;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getMetodoPago() {
		return metodoPago;
	}


	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}


	@Override
	public String toString() {
		return "MetodosPago [id=" + id + ", metodoPago=" + metodoPago + "]";
	}



}


