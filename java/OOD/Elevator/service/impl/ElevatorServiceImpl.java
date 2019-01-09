package Elevator.service.impl;

import Elevator.exception.LiftNotAvailableException;
import Elevator.model.Lift;
import Elevator.model.LiftDirection;
import Elevator.service.ElevatorService;
import Elevator.service.LiftService;

public class ElevatorServiceImpl implements ElevatorService{

	private LiftService liftService;
	
	public ElevatorServiceImpl(LiftService liftService){
		this.liftService = liftService;
	}

	@Override
	public void addRequest(int floorNo,LiftDirection direction) throws LiftNotAvailableException {
		Lift lift = this.liftService.getNextLift(floorNo,direction);
		if(lift.getCurrentTotalWeight()==0) {
			lift.setDirection(direction);
		}
		lift.addRequestedFloor(floorNo);
		
	}
	


}
