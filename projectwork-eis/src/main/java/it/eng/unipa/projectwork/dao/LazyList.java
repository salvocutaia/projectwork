package it.eng.unipa.projectwork.dao;

import java.util.List;

public interface LazyList<E>{

	public List<E> getResults();
	public void setResults(List<E> values);

	public int getMaxResults();
	public int getFirstResult();
	public long getTotalRows();

	public void setMaxResults(int maxResults);
	public void setFirstResult(int firstResult);
	public void setTotalRows(long totalRow);

	
	
}
