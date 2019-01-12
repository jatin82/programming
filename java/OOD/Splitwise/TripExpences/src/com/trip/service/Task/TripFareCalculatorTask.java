package com.trip.service.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.trip.model.BalanceFare;
import com.trip.model.Person;

public class TripFareCalculatorTask {
	
	
	public static List<BalanceFare> getTransactionDetails(List<Person> persons){
		List<BalanceFare> fares = new ArrayList<>();
		
		float fareTotal = 0;
		
		for(Person person : persons) {
			fareTotal+= person.getFarePaid();
		}
		
		float avgFare = (float)fareTotal/persons.size();
	
		
		for(Person person: persons) {
			person.setBalance(avgFare - person.getFarePaid());
		}
		
		Collections.sort(persons);
		
		int up = 0;
		int down = persons.size()-1;
		while(up < down) {
			Person personUp = persons.get(up);
			Person personDown = persons.get(down);
			
			float diff = personUp.getBalance() + personDown.getBalance();
			float paid = 0;
			if(diff==0) {
				up++;
				down--;
				paid = Math.abs(personUp.getBalance());
			}
			else if(diff<0) {
				paid = Math.abs(personDown.getBalance());
				personUp.setBalance(diff);
				down--;
			}
			else {
				personDown.setBalance(diff);
				paid = Math.abs(personUp.getBalance());
				up++;
			}
			BalanceFare balanceFare = new BalanceFare(personUp, personDown, paid);
			
			fares.add(balanceFare);
		}
		return fares;
		
	}

}
