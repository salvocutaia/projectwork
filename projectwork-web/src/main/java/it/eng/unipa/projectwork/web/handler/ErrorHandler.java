package it.eng.unipa.projectwork.web.handler;

import java.util.Arrays;
import java.util.List;

import javax.ejb.EJBAccessException;
import javax.ws.rs.core.Response;

import it.eng.unipa.projectwork.validation.NotValidException;



@javax.ws.rs.ext.Provider
public class ErrorHandler
        implements javax.ws.rs.ext.ExceptionMapper<Throwable> {
    public javax.ws.rs.core.Response toResponse(Throwable exn) {
        // Construct+return the response here...
    	if(getCause(EJBAccessException.class, exn)!=null){
    		return Response.status(403).type("application/json").entity(new Message("User profile is not authorized\"]}")).build();
    	} else {
			NotValidException cause = getCause(NotValidException.class, exn);
			if(cause!=null){
				return Response.status(400).type("application/json").entity(new Message(cause.getErrorMessages())).build();	
			}else{
				return Response.status(500).type("application/json").entity(new Message(exn.getMessage())).build();
			}
		}
    	
    }



	public static <T extends Throwable> T getCause(Class<T> expected,Throwable exn) {
		if(exn!=null && expected.isInstance(exn)){
			return (T)exn;
		}else if(exn!=null){
			return getCause(expected, exn.getCause());
		}else{
			return null;
		}
	}
	
	public static class Message{
		
		List<String> messages;
		
		public Message(String... messages) {
			this.messages = Arrays.asList(messages);
		}
		
		public Message(List<String> messages){
			this.messages = messages;
		}
		
		public List<String> getMessages() {
			return messages;
		}
		
	}
}