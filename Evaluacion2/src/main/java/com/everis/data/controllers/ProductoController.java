package com.everis.data.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

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
		public String home(HttpSession session){
			Integer registrado = (Integer) session.getAttribute("registrado");
			if (registrado == 1 ) {
				return "/prod/prodForm.jsp";
			}
			return "login.jsp";
		}
	
		@RequestMapping("/registrar")
		private String registrar(HttpSession session,@RequestParam("name") String name,
				@RequestParam("description") String description,
				@RequestParam("price") Integer price) {
			Integer registrado = (Integer) session.getAttribute("registrado");
			if (registrado == 1 ) {	
				Producto prod = new Producto();
				prod.setName(name);
				prod.setDescription(description);
				prod.setPrice(price);
				pService.save(prod);
				return "/prod/prodForm.jsp";
			}
			return "login.jsp";	
		}
		

		@RequestMapping("/tabla_productos")
		public String tablaProductos(HttpSession session,Model modelo){
			Integer registrado = (Integer) session.getAttribute("registrado");
			if (registrado == 1 ) {	
				ArrayList<Producto> prodTable = new ArrayList<Producto>();
				prodTable = (ArrayList<Producto>)pService.findAll();
				modelo.addAttribute("prodTable",prodTable);
				//modelo.addAttribute("listCarro",cService.findAll());
				return "/prod/prodTable.jsp";
			}
			return "login.jsp";	
		}
		
		@RequestMapping("/editar/{id}")
		public String editar(HttpSession session,@PathVariable("id") Long id, Model model){
			Integer registrado = (Integer) session.getAttribute("registrado");
			if (registrado == 1 ) {	
				model.addAttribute("producto", pService.finById(id));
				return "/prod/editProdForm.jsp";
			}
			return "login.jsp";	
			
		}
		
		@RequestMapping("/update")
		public String update(HttpSession session,@ModelAttribute("producto") Producto prod){
			Integer registrado = (Integer) session.getAttribute("registrado");
			if (registrado == 1 ) {	
				pService.save(prod);
				return "redirect:/producto/tabla_productos";
			}
			return "login.jsp";	
		}
		
		@RequestMapping("/eliminar/{id}")
		public String eliminar(HttpSession session,@PathVariable("id") Long id, Model model){
			Integer registrado = (Integer) session.getAttribute("registrado");
			if (registrado == 1 ) {	
				pService.deleteById(id);
				return "redirect:/prod/producto/tabla_productos";
			}
			return "login.jsp";	
		}
}
