package com.everis.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Usuario;
import com.everis.data.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository uRepository;
	
	public void save(Usuario user) {
		uRepository.save(user);
	}
	public List<Usuario> findAll(){
		return uRepository.findAll();
	}
	public Usuario findById(Long id) {
		return uRepository.findById(id).get();
	}
	public void deleteById(Long id) {
		uRepository.deleteById(id);
	}
}
