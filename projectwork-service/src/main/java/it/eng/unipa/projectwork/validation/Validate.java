package it.eng.unipa.projectwork.validation;

@FunctionalInterface
public interface Validate {
	
	public void validate() throws NotValidException;

}
