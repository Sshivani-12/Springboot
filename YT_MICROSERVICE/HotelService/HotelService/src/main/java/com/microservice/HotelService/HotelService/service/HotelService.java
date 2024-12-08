package com.microservice.HotelService.HotelService.service;

import java.util.List;

import com.microservice.HotelService.HotelService.entities.Hotel;

public interface HotelService {

	Hotel saveHotel(Hotel hotel);

	List<Hotel> getAllHotel();

	Hotel getHotel(String id);

}
