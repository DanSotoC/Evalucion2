package com.everis.data.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String inicioCarro(HttpSession session, Model modelo){
		Integer registrado = (Integer) session.getAttribute("registrado");
		if (registrado == 1 ) {
			ArrayList<Producto> prodTable = (ArrayList<Producto>)pService.findAll();
			modelo.addAttribute("listProd",prodTable);
			modelo.addAttribute("listCarro",cService.findAll());
			modelo.addAttribute("carroPrecioTotal",0);
			return "carro.jsp";
		}
		return "login.jsp";
	}

	@RequestMapping("/agregar")
	public String agregar(@RequestParam("name") String name){
		Carro carro = new Carro();
		carro.setName(name);
		cService.save(carro);
		return "redirect:/carro";
	}
	
	@RequestMapping("/agregarUser")
	public String AgregarCarroUser(@RequestParam("carro_id") String carro_id, @RequestParam("usuario_id") String usuario_id ){
		Carro carrito = cService.findById(Long.parseLong(carro_id) );
		Usuario user = new Usuario();
		user = uService.findById(Long.parseLong(usuario_id));
		
		carrito.setUsuario(user);
		cService.save(carrito);
		return "redirect:/usuario/tabla_usuarios";
	}
	

	@RequestMapping("/agregarProd")
	public String AgregarCarroProd(@ModelAttribute("producto") ArrayList<Producto> producto,@RequestParam("carro_id") String carro_id){
		/*Carro carrito = cService.findById(Long.parseLong(carro_id) );
		carrito.setProductos(producto);
		cService.save(carrito);*/
		return "redirect:/carro/";
	}
	
}
