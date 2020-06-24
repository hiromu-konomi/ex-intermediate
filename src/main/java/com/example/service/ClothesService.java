package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Clothes;
import com.example.repository.ClothesRepository;

@Service
@Transactional
public class ClothesService {

	@Autowired
	private ClothesRepository repository;
	
	public Clothes receive(Integer gender, String color) {
		return repository.findBy(gender, color);
	}
}
