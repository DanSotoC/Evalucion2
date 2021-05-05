package com.everis.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.services.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired 
	LoginService lService;
	
	@RequestMapping("/acceso")
	public String acceso(@RequestParam("mail") String mail,
						 @RequestParam("password") String password){
		System.out.println("Post operando");
		if(lService.Autentication(mail,password)){
			return "userForm.jsp";
		}
		else {
			System.out.println("Validacion Fallida");
			return "login.jsp";
	   }
	}
}
