package com.everis.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Carro;
import com.everis.data.repositories.CarroRepository;

@Service
public class CarroService {
	@Autowired
	CarroRepository cRepository;
	
	public void save(Carro carro) {
		cRepository.save(carro);
	}

	public Object findAll() {
		return cRepository.findAll();
	}

	public Carro findById(Long id) {
		return cRepository.findById(id).get();
	}

}
