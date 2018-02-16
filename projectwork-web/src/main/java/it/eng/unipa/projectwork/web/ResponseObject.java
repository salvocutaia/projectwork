package it.eng.unipa.projectwork.web;

public class ResponseObject<T> {
	
	T entity;
	
	public ResponseObject(T entity) {
		this.entity = entity;
	}
	
	public T getEntity() {
		return entity;
	}

}
