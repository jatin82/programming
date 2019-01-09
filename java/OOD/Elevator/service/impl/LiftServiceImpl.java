package Elevator.service.impl;

import java.util.HashSet;
import java.util.List;

import Elevator.exception.LiftNotAvailableException;
import Elevator.model.Lift;
import Elevator.model.LiftDirection;
import Elevator.service.LiftService;

public class LiftServiceImpl implements LiftService{

	private List<Lift> lifts;
	
	public LiftServiceImpl(int numberOfLifts){
		for(int i=0;i<numberOfLifts;i++) {
			lifts.add(new Lift(3,new HashSet<Integer>(),LiftDirection.UP));
		}
	}
	
	@Override
	public boolean checkIsFull(Lift lift) {
		return lift.getCapacity() > lift.getCurrentTotalWeight();
	}

	@Override
	public Lift getNextLift(int sourcefloorNo, LiftDirection direction) throws LiftNotAvailableException {
		Lift lift = null;
		int diff = -1;
		for(Lift current : lifts) {
			if(lift.getCurrentTotalWeight()==0 || (!checkIsFull(current) && direction.equals(lift.getDirection()))) {
				int liftDist = Math.abs(sourcefloorNo - current.getCurrentFloor());
				if(diff == -1 || diff > liftDist) {
					diff = liftDist;
					lift = current;
				}
			}
		}
		if(lift==null) throw new LiftNotAvailableException();
		return lift;
	}

}
