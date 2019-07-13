package Elevator.service;

import Elevator.exception.LiftNotAvailableException;
import Elevator.model.LiftDirection;

public interface ElevatorService {
	
	public void addRequest(int sourceFloorNo,LiftDirection direction) throws LiftNotAvailableException;
	
}
