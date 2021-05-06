package com.everis.data.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String Login(HttpSession session) {
		//return "/user/userForm.jsp";
		session.setAttribute("registrado", 0);
		return "login.jsp";
	}
}
