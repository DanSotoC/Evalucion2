package com.everis.data.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Carro;
import com.everis.data.models.Producto;
import com.everis.data.models.Usuario;
import com.everis.data.services.CarroService;
import com.everis.data.services.ProductoService;
import com.everis.data.services.UsuarioService;

@Controller
@RequestMapping("/carro")
public class CarroController {
	@Autowired
	CarroService cService;
	@Autowired
	UsuarioService uService;
	@Autowired
	ProductoService pService;
	
	@RequestMapping("")
	public String inicioCarro(){
		return "carro.jsp";
	}
	@RequestMapping("/agregar")
	public String agregar(@RequestParam("name") String name){
		Carro carro = new Carro();
		carro.setName(name);
		cService.save(carro);
		return "redirect:/carro";
	}
	
	@RequestMapping("/agregarUser/{id}/{id2}")
	public String AgregarCarroUser(@PathVariable("id") Long id, @PathVariable("id2") Long id2 ){
		Carro carrito = cService.findById(id2);
		Usuario user = new Usuario();
		user = uService.findById(id);
		
		carrito.setUsuario(user);
		return "redirect:/usuario/tabla_usuarios";
	}
	
}
