package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelRepository repository;
	
	public List<Hotel> receive(Integer price) {
		return repository.findBy(price);
	}
	
	public List<Hotel> receiveAll(){
		return repository.findAll();
	}
}
