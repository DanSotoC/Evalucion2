package com.everis.data.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Usuario;
import com.everis.data.services.UsuarioService;
import com.everis.data.utils.Validacion;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
		
		@Autowired
		UsuarioService uService;
		
	
		@RequestMapping("/registrar")
		private String registrar(@RequestParam("name") String name,
				@RequestParam("lastname") String lastname,
				@RequestParam("rut") String rut,
				@RequestParam("mail") String mail,
				@RequestParam("password") String password) {
			Usuario user = new Usuario();
			user.setName(name);
			user.setLastname(lastname);
			user.setPassword(password);
			user.setMail(mail);
			if(Validacion.validarRut(rut)){
				user.setRut(rut);
			}
			else {
				return "error.jsp"; 
			}
			uService.save(user);
			return "userForm.jsp";
		}
		@RequestMapping("/editar/{id}")
		public String editar(@PathVariable("id") Long id, Model model){
			model.addAttribute("usuario", uService.findById(id));
			return "editUserForm.jsp";
			
		}
		@RequestMapping("/update")
		public String update(@ModelAttribute("usuario") Usuario user){
			uService.save(user);
			return "redirect:/";
		}
		@RequestMapping("/eliminar/{id}")
		public String eliminar(@PathVariable("id") Long id, Model model){
			uService.deleteById(id);
			return "redirect:/usuario/tabla_usuarios";
			
		}
		@RequestMapping("/tabla_usuarios")
		public String tablaUsuarios(Model modelo){
			ArrayList<Usuario> userTable = new ArrayList<Usuario>();
			userTable = (ArrayList<Usuario>)uService.findAll();
			modelo.addAttribute("userTable",userTable);
			return "userTable.jsp";
		}
}
