package com.trip;

import java.util.Scanner;

import com.trip.exception.PlatformException;
import com.trip.service.impl.TripFareCalculatorServiceImpl;
import com.trip.validator.impl.ValidatorInputImpl;

public class TripFareApplication {
	
	/**
	 * 
Test Cases :

a, b, c, d
a 100 snacks
c 300 food
d 200 food

a, b, c, d
c 400 food
d 300 food

Shubham, Rajan, Jatin, Vj
Shubham 11956 Tickets
Rajan 5670 Food
Jatin 2240 Bus
Vj 2753 Cabs

	 */
	
	public static void main(String[] args) throws PlatformException {
		TripFare tripFare = TripFare.getInstance(new ValidatorInputImpl(), new TripFareCalculatorServiceImpl(),new Scanner(System.in));
		tripFare.run();
	}

}
