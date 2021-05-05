package com.everis.data.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Producto;
import com.everis.data.services.ProductoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {
		
		@Autowired
		ProductoService pService;
		
	
		@RequestMapping("/registrar")
		private String registrar(@RequestParam("name") String name,
				@RequestParam("description") String description,
				@RequestParam("price") Integer price) {
			Producto prod = new Producto();
			prod.setName(name);
			prod.setDescription(description);
			prod.setPrice(price);
			return "prodForm.jsp";
		}
		

		@RequestMapping("/tabla_productos")
		public String tablaProductos(Model modelo){
			ArrayList<Producto> prodTable = new ArrayList<Producto>();
			prodTable = (ArrayList<Producto>)pService.findAll();
			modelo.addAttribute("prodTable",prodTable);
			return "userTable.jsp";
		}
}
