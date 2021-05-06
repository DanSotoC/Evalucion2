package com.everis.data.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Usuario;
import com.everis.data.services.CarroService;
import com.everis.data.services.UsuarioService;
import com.everis.data.utils.Validacion;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
		
		@Autowired
		UsuarioService uService;
		@Autowired
		CarroService cService;
		
		@RequestMapping("")
		private String home(HttpSession session) {
			Integer registrado = (Integer) session.getAttribute("registrado");
			if (registrado == 1 ) {
				return "/user/userForm.jsp";
			}
			
			return "login.jsp";
		}
	
		@RequestMapping("/registrar")
		private String registrar(HttpSession session,@RequestParam("name") String name,
				@RequestParam("lastname") String lastname,
				@RequestParam("rut") String rut,
				@RequestParam("mail") String mail,
				@RequestParam("password") String password) {
			Integer registrado = (Integer) session.getAttribute("registrado");
			if (registrado == 1 ) {	
				Usuario user = new Usuario();
				user.setName(name);
				user.setLastname(lastname);
				user.setPassword(password);
				user.setMail(mail);
				if(Validacion.validarRut(rut)){
					user.setRut(rut);
				}
				else {
					return "/user/error.jsp"; 
				}
				uService.save(user);
				return "/user/userForm.jsp";
			}
			return "login.jsp";
		}
		
		@RequestMapping("/editar/{id}")
		public String editar(HttpSession session,@PathVariable("id") Long id, Model model){
			Integer registrado = (Integer) session.getAttribute("registrado");
			if (registrado == 1 ) {	
				model.addAttribute("usuario", uService.findById(id));
				return "/user/editUserForm.jsp";
			}
			return "login.jsp";
			
		}
		
		@RequestMapping("/update")
		public String update(HttpSession session,@ModelAttribute("usuario") Usuario user){
			Integer registrado = (Integer) session.getAttribute("registrado");
			if (registrado == 1 ) {		
				uService.save(user);
				return "redirect:/";
			}
			return "login.jsp";
		}
		
		@RequestMapping("/eliminar/{id}")
		public String eliminar(HttpSession session,@PathVariable("id") Long id, Model model){
			Integer registrado = (Integer) session.getAttribute("registrado");
			if (registrado == 1 ) {	
				uService.deleteById(id);
				return "redirect:/usuario/tabla_usuarios";
			}
			return "login.jsp";
			
		}
		
		@RequestMapping("/tabla_usuarios")
		public String tablaUsuarios(HttpSession session,Model modelo){
			Integer registrado = (Integer) session.getAttribute("registrado");
			if (registrado == 1 ) {	
				ArrayList<Usuario> userTable = new ArrayList<Usuario>();
				userTable = (ArrayList<Usuario>)uService.findAll();
				modelo.addAttribute("userTable",userTable);
				modelo.addAttribute("listCarro",cService.findAll());
				return "/user/userTable.jsp";
			}
			return "login.jsp";
		}
		
		@RequestMapping("/acceso")
		public String acceso(@RequestParam("mail") String mail,
							 @RequestParam("password") String password,
							 HttpSession session){
			if(uService.Autentication(mail,password)){
				session.setAttribute("mail", mail);
				session.setAttribute("registrado", 1);
				return "/user/userForm.jsp";
			}
			else {
				session.removeAttribute("registrado");
				session.setAttribute("registrado", 0);
				return "login.jsp";
		   }
		}

}
