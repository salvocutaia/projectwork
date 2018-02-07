package it.eng.unipa.projectwork.service;

import java.util.ArrayList;
import java.util.List;

public class LazyArrayList<E> implements LazyList<E> {

	private int maxResults = 10;
	private int firstResult = 0;
	private long totalRows = 0;
	
	private List<E> results = new ArrayList<E>();
	
	public LazyArrayList() {
		
	}
	
	public LazyArrayList(List<E> results,int firstResult,int maxResults,long totalRows) {
		this.results = results;
		this.firstResult = firstResult;
		this.maxResults = maxResults;
		this.totalRows = totalRows;
	}

	public int getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
	
	public int getFirstResult() {
		return firstResult;
	}
	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}
	
	public long getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}
	
	@Override
	public List<E> getResults() {
		return results;
	}
	
	public void setResults(List<E> values) {
		this.results = values;
	}
	
}
