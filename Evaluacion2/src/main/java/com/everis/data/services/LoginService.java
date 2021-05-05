package com.everis.data.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Usuario;
import com.everis.data.repositories.UsuarioRepository;

@Service
public class LoginService {
	@Autowired
	UsuarioRepository uRepository;
	
	public boolean Autentication (String mail, String password) {
		Usuario person = uRepository.findByMail(mail);
		if (person == null)
		{
			return false;
		}
		else {
			if(BCrypt.checkpw(password, person.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	
}
