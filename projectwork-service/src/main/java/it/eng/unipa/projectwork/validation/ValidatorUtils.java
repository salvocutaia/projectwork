package it.eng.unipa.projectwork.validation;

public class ValidatorUtils {
	
	
	public static <T> T validate(BL<T> bl,Validate... vs) throws NotValidException{
		ValidationInfo vi = new ValidationInfo();
		for(Validate v : vs){
			v.validate(vi);
		}
		return bl.execute();
	}
	
	
}
