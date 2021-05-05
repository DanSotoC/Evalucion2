package com.everis.data.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=3, max=20)
	private String name;
	@Size(min=3, max=30)
	private String lastname;
	private String rut;
	private String mail;
	@Size(min=4)
	private String password;
	
	//Inicio Relacion
	@OneToOne(mappedBy="usuario", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Carro carro;
	//Fin Relacion

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


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getRut() {
		return rut;
	}


	public void setRut(String rut) {
		this.rut = rut;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Usuario(@Size(min = 3, max = 20) String name, @Size(min = 3, max = 30) String lastname, String rut,
			String mail, @Size(min = 4) String password) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.rut = rut;
		this.mail = mail;
		this.password = password;
	}
	
	
}
