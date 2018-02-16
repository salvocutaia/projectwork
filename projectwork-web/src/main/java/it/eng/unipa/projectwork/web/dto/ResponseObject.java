package it.eng.unipa.projectwork.web.dto;

public class ResponseObject<T> {
	
	T entity;
	
	public ResponseObject(T entity) {
		this.entity = entity;
	}
	
	public T getEntity() {
		return entity;
	}

}
