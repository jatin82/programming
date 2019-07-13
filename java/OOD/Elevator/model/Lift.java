package Elevator.model;

import java.util.Queue;
import java.util.Set;

public class Lift {
	
	public Lift(int capacity, Set<Integer> queue,LiftDirection direction) {
		this.capacity = capacity;
		this.currentFloor = 0;
		this.currentTotalWeight = 0;
		this.requestedFloorList = queue;
		this.direction = direction;
	}
	private LiftDirection direction;
	
	private int capacity;

	private int currentFloor;
	
	private int currentTotalWeight;
	
	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	
	public void setTotalPassenger(int passengers) {
		this.currentTotalWeight = passengers;
	}
	
	public int getCurrentTotalWeight() {
		return this.currentTotalWeight;
	}
	
	public LiftDirection getDirection() {
		return this.direction;
	}

	public int getCapacity() {
		return capacity;
	}

	public void addRequestedFloor(int floorNo) {
		
		requestedFloorList.add(floorNo);
	}
	
	
	public void setDirection(LiftDirection direction) {
		this.direction = direction;
	}
	
	private Set<Integer> requestedFloorList;
	
	
}
