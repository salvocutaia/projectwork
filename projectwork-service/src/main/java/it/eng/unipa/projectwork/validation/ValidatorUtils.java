package it.eng.unipa.projectwork.validation;

public class ValidatorUtils {
	
	
	public static <T> T validate(BL<T> bl,Validate... vs) throws NotValidException{
		for(Validate v : vs){v.validate();}
		return bl.execute();
	}
	
	
	public static boolean isEmpty(Object o){
		return o==null || o.toString().isEmpty();
	}

}
