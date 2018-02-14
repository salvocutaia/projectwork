package it.eng.unipa.projectwork.validation;

import it.eng.unipa.projectwork.validation.ValidationInfo;

@FunctionalInterface
public interface Validate {
	
	public void validate(ValidationInfo v) throws NotValidException;
	
}
