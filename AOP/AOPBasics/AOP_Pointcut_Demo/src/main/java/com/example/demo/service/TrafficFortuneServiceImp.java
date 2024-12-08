package com.example.demo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
@Service
public class TrafficFortuneServiceImp implements TrafficFortuneService {

	@Override
	public String getFortune() {

		try {
			// simulate a delay
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		return "Expect heavy traffic this morning!";
	}

	@Override
	public String getFortune(boolean tripWise) {

		if(tripWise)
		{
			throw new RuntimeException("Major accident highway");
			
		}
		return getFortune();
	}

}
