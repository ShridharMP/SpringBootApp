package com.patil.software.solutions.error;

public class EmployeeNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6934666409866884750L;

	public EmployeeNotFoundException(String message)
	{
		super(message);
	}

}
