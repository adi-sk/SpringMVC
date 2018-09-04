package com.zycus.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zycus.entity.Flight;
import com.zycus.service.FlightService;

public class TestFlight {
ApplicationContext context = new ClassPathXmlApplicationContext("mvc-servlet.xml");
	
	FlightService service = (FlightService)context.getBean("flightService");
	
	@Test
	public void testFlightReg(){
		Flight flight = new Flight();
		flight.setFlightNo("123");
		flight.setCarrier("Demo");
		flight.setSource("Mumbai");
		flight.setDestination("Benguluru");
		flight.setDuration(2);
		
		service.addNewFlight(flight);
		
	}

}
