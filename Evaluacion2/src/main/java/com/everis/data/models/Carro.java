package com.everis.data.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="carros")
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=4, max=20)
	private String name;
	//Inicio Relacion
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usuario_id")
	private Usuario usuario;
	//Fin Relacion
	//Inicio Relacion
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="carros_productos",
			   joinColumns = @JoinColumn(name="producto_id"),
			   inverseJoinColumns = @JoinColumn(name ="carro_id"))
	private List<Producto> productos;
	

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	//Fin Relacion
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
