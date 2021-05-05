package com.tienda.modelo;

import javax.persistence.Column;

// default package
// Generated 28 abr. 2021 19:30:06 by Hibernate Tools 5.4.30.Final

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "roles")
public class Roles implements java.io.Serializable {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "rol", nullable = true)
	private String rol;


	public Roles() {
	}

	public Roles(String rol) {
		this.rol = rol;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", rol=" + rol + "]";
	}
	
	
}
