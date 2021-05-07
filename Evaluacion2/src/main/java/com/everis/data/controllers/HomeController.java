package com.everis.data.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.data.models.Usuario;
import com.everis.data.services.UsuarioService;

@Controller
public class HomeController {
	@Autowired
	UsuarioService uService;
	
	@RequestMapping("/")
	public String Login(HttpSession session, Model model) {
		//return "/user/userForm.jsp";
		Integer registrado = (Integer) session.getAttribute("registrado");
		if (registrado != null && registrado == 1) {
				 return "login.jsp";
			 }else {
				session.setAttribute("registrado", 0);
				model.addAttribute("usuario",new Usuario());
				return "login.jsp";
			 }
	}
}
