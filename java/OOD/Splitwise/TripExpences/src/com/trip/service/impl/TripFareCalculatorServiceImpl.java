package com.trip.service.impl;

import java.util.List;

import com.trip.model.BalanceFare;
import com.trip.model.Person;
import com.trip.service.TripFareCalculatorService;
import com.trip.service.Task.TripFareCalculatorTask;

public class TripFareCalculatorServiceImpl implements TripFareCalculatorService{

	
	@Override
	public List<BalanceFare> getAllFareBalnces(List<Person> persons) {
		return TripFareCalculatorTask.getTransactionDetails(persons);
	}

}
