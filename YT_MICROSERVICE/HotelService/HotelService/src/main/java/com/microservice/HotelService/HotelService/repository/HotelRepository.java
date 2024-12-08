package com.microservice.HotelService.HotelService.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.HotelService.HotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,String>{

}
