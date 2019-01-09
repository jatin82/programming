package Elevator.service;

import Elevator.exception.LiftNotAvailableException;
import Elevator.model.Lift;
import Elevator.model.LiftDirection;

public interface LiftService {

	public boolean checkIsFull(Lift lift);
	
	public Lift getNextLift(int sourceFloorNo, LiftDirection direction) throws LiftNotAvailableException;
	

}
