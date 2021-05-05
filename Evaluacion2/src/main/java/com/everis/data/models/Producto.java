package com.everis.data.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;

@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=3, max=20)
	private String name;
	@Size(min=3, max=90)
	private String description;
	@Min(0)
	@Max(1000000)
	private Integer price;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="carros_productos",
			   joinColumns = @JoinColumn(name="carro_id"),
			   inverseJoinColumns = @JoinColumn(name="producto_id"))
	private List<Carro> carros;

	
	public Producto() {	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}

	

	
}
