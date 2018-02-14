package it.eng.unipa.projectwork.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationInfo{
		
		private List<String> messages  = new ArrayList<>();
		
		public void isEmpty(Object o,String... messages){
			apply(()->{return o==null || o.toString().isEmpty();},messages);
		}
		
		public void isNotEmpty(Object o,String... messages){
			apply(()->{return o!=null && !o.toString().isEmpty();},messages);
		}

		public void apply(SimpleValidate p,String... messages){
			if(!p.validate()){
				for(String message : messages){
					this.messages.add(message);
				}
			}
		}
		
		
		public List<String> getMessages() {
			return messages;
		}
		
	}