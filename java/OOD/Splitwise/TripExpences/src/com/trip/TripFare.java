package com.trip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.trip.exception.InvalidInputException;
import com.trip.exception.PlatformException;
import com.trip.model.BalanceFare;
import com.trip.model.Person;
import com.trip.service.TripFareCalculatorService;
import com.trip.validator.ValidateInput;

public class TripFare {

	private volatile static TripFare tripFare;

	private Scanner scanner;

	private ValidateInput validateInput;

	private TripFareCalculatorService calculatorService;

	private TripFare(ValidateInput input, TripFareCalculatorService calculatorService, Scanner scanner) {
		this.validateInput = input;
		this.calculatorService = calculatorService;
		this.scanner = scanner;
	}

	public static TripFare getInstance(ValidateInput validateInput, TripFareCalculatorService calculatorService,
			Scanner scanner) {
		if (tripFare == null) {
			synchronized (TripFare.class) {
				if (tripFare == null)
					tripFare = new TripFare(validateInput, calculatorService, scanner);
			}
		}
		return tripFare;
	}

	public void run() throws PlatformException {
		String input = this.scanner.nextLine();
		String[] inputs = input.split(",");

		Set<String> setNames = new HashSet<>();

		for (String in : inputs) {
			setNames.add(in.trim());
		}

		List<Person> persons = new ArrayList<>();
		try {
			while (true) {
				input = this.scanner.nextLine();

				if (this.validateInput.valdiateInputs(input)) {
					inputs = input.split(" ");
					persons.add(new Person(inputs[0], inputs[1]));
					setNames.remove(inputs[0]);
				} else {
					throw new InvalidInputException("Please Enter Valid Input");
				}
			}
		} catch (Exception e) {

		}
		for (String leftPerson : setNames) {
			persons.add(new Person(leftPerson, "0"));
		}

		List<BalanceFare> fares = this.calculatorService.getAllFareBalnces(persons);
		for (BalanceFare transaction : fares) {
			System.out.println(transaction);
		}
	}

}
