package com.zycus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zycus.dao.CrudRepository;
import com.zycus.entity.Flight;

@Service //alternative for component annotation
public class FlightService {

	@Autowired
	private CrudRepository crudRepository;
	
	public void addNewFlight(Flight flight){
		crudRepository.create(flight);
	}
	
	public List<Flight> getAvailableFlights(){
		return crudRepository.fetchAll(Flight.class);
	}
	
	public Flight getFlight(String flightNo){
		return crudRepository.fetchById(flightNo, Flight.class);
	}
	
}
