package com.tienda.modelo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos implements java.io.Serializable {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "id_categoria", nullable = true)
	private int categorias;
	@Column(name = "nombre", nullable = true)
	private String nombre;
	@Column(name = "descripcion", nullable = true)
	private String descripcion;
	@Column(name = "precio", nullable = true)
	private double precio;
	@Column(name = "stock")
	private int stock;
	@Column(name = "fecha_alta")
	private Timestamp fecha_alta;
	@Column(name = "fecha_baja")
	private Timestamp fecha_baja;
	@Column(name = "impuesto")
	private float impuesto;
	
	
	public Productos() {
		super();
	}


	public Productos(int id, int categorias, String nombre, String descripcion, double precio, int stock,
			Timestamp fecha_alta, Timestamp fecha_baja, float impuesto) {
		super();
		this.id = id;
		this.categorias = categorias;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.fecha_alta = fecha_alta;
		this.fecha_baja = fecha_baja;
		this.impuesto = impuesto;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCategorias() {
		return categorias;
	}


	public void setCategorias(int categorias) {
		this.categorias = categorias;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public Timestamp getFecha_alta() {
		return fecha_alta;
	}


	public void setFecha_alta(Timestamp fecha_alta) {
		this.fecha_alta = fecha_alta;
	}


	public Timestamp getFecha_baja() {
		return fecha_baja;
	}


	public void setFecha_baja(Timestamp fecha_baja) {
		this.fecha_baja = fecha_baja;
	}


	public float getImpuesto() {
		return impuesto;
	}


	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}


	@Override
	public String toString() {
		return "Productos [id=" + id + ", categorias=" + categorias + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", precio=" + precio + ", stock=" + stock + ", fecha_alta=" + fecha_alta
				+ ", fecha_baja=" + fecha_baja + ", impuesto=" + impuesto + "]";
	}

	
	
}
