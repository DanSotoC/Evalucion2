package com.everis.data.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Producto;
import com.everis.data.models.Usuario;
import com.everis.data.services.CarroService;
import com.everis.data.services.ProductoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {
		
		@Autowired
		ProductoService pService;
		
		@Autowired
		CarroService cService;
		
		@RequestMapping("")
		public String home() {
			return "/prod/prodForm.jsp";
		}
	
		@RequestMapping("/registrar")
		private String registrar(@RequestParam("name") String name,
				@RequestParam("description") String description,
				@RequestParam("price") Integer price) {
			Producto prod = new Producto();
			prod.setName(name);
			prod.setDescription(description);
			prod.setPrice(price);
			pService.save(prod);
			return "/prod/prodForm.jsp";
		}
		

		@RequestMapping("/tabla_productos")
		public String tablaProductos(Model modelo){
			ArrayList<Producto> prodTable = new ArrayList<Producto>();
			prodTable = (ArrayList<Producto>)pService.findAll();
			modelo.addAttribute("prodTable",prodTable);
			//modelo.addAttribute("listCarro",cService.findAll());
			return "/prod/prodTable.jsp";
		}
		
		@RequestMapping("/editar/{id}")
		public String editar(@PathVariable("id") Long id, Model model){
			model.addAttribute("producto", pService.finById(id));
			return "/prod/editProdForm.jsp";
			
		}
		@RequestMapping("/update")
		public String update(@ModelAttribute("producto") Producto prod){
			pService.save(prod);
			return "redirect:/producto/tabla_productos";
		}
		@RequestMapping("/eliminar/{id}")
		public String eliminar(@PathVariable("id") Long id, Model model){
			pService.deleteById(id);
			return "redirect:/prod/producto/tabla_productos";
			
		}
}
