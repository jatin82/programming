package com.trip.validator;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValidateInput.
 */
public interface ValidateInput {

	/** The num of tokens. */
	public int FARE_INPUT_TOKENS = 3;

	/**
	 * Valdiate inputs.
	 *
	 * @param input the input
	 * @return true, if successful
	 */
	default boolean valdiateInputs(String input) {

		String[] inputs = input.split(" ");

		return FARE_INPUT_TOKENS == inputs.length &&  validateFloat(inputs[1]);
	}
	
	/**
	 * Validate fare.
	 *
	 * @param fare the fare
	 * @return true, if successful
	 */
	public boolean validateFloat(String fare);

	

}
