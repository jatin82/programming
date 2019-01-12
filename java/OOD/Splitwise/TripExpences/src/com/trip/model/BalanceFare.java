package com.trip.model;

/**
 * The Class BalanceFare.
 */
public class BalanceFare {

	/** The person pay. */
	private Person personPay;

	/** The person due. */
	private Person personDue;

	/** The ammount. */
	private float ammount;

	/**
	 * Instantiates a new balance fare.
	 *
	 * @param personPay the person pay
	 * @param personDue the person due
	 * @param ammount   the ammount
	 */
	public BalanceFare(Person personDue, Person personPay, float ammount) {
		super();
		this.personPay = personPay;
		this.personDue = personDue;
		this.ammount = ammount;
	}

	/**
	 * Gets the person pay.
	 *
	 * @return the person pay
	 */
	public Person getPersonPay() {
		return personPay;
	}

	/**
	 * Sets the person pay.
	 *
	 * @param personPay the new person pay
	 */
	public void setPersonPay(Person personPay) {
		this.personPay = personPay;
	}

	/**
	 * Gets the person due.
	 *
	 * @return the person due
	 */
	public Person getPersonDue() {
		return personDue;
	}

	/**
	 * Sets the person due.
	 *
	 * @param personDue the new person due
	 */
	public void setPersonDue(Person personDue) {
		this.personDue = personDue;
	}

	/**
	 * Gets the ammount.
	 *
	 * @return the ammount
	 */
	public float getAmmount() {
		return ammount;
	}

	/**
	 * Sets the ammount.
	 *
	 * @param ammount the new ammount
	 */
	public void setAmmount(float ammount) {
		this.ammount = ammount;
	}
	
	@Override
	public String toString() {
		return this.personPay.getName() + " -> " + this.personDue.getName() + " " + this.ammount;
	}
}
