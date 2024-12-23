package com.microservice.HotelService.HotelService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.microservice.HotelService.HotelService.entities.Hotel;
import com.microservice.HotelService.HotelService.exception.ResourceNotFound;
import com.microservice.HotelService.HotelService.repository.HotelRepository;

@Service
public class HotelServiceImp implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		String random = UUID.randomUUID().toString();
		hotel.setId(random);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String id) {
		return hotelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("user with given ID not found" + id));
	}

}
