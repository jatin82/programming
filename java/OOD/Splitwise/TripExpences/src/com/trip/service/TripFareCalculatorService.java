package com.trip.service;

import java.util.List;

import com.trip.model.BalanceFare;
import com.trip.model.Person;

public interface TripFareCalculatorService {
	
	public List<BalanceFare> getAllFareBalnces(List<Person> persons);

}
