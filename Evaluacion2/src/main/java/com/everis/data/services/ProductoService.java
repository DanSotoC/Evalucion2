package com.everis.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Producto;
import com.everis.data.repositories.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository pRepository;
	
	public List<Producto> findAll() {
		return pRepository.findAll();
	}
	public void save(Producto prod){
		pRepository.save(prod);
	}
	public Producto finById(Long id) {
		return pRepository.findById(id).get(); 
	}
	public void deleteById(Long id){
		pRepository.deleteById(id);
	}
}
