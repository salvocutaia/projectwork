package it.eng.unipa.projectwork.validation;

import java.util.Arrays;
import java.util.List;

public class NotValidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> errorMessages;
	
	public NotValidException(String... errorMessages){
		this.errorMessages = Arrays.asList(errorMessages);
	}
	
	public NotValidException(List<String> errorMessages){
		this.errorMessages = errorMessages;
	}
	
	public List<String> getErrorMessages() {
		return errorMessages;
	}
	
	
	
}
