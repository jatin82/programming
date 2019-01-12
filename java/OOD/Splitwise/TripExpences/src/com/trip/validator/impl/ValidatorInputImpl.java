package com.trip.validator.impl;

import com.trip.validator.ValidateInput;

public class ValidatorInputImpl implements ValidateInput{


	@Override
	public boolean validateFloat(String fare) {
		try {
			Float.parseFloat(fare);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

}
