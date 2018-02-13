package it.eng.unipa.projectwork.dao;



import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import it.eng.unipa.projectwork.model.AEntity;

@Local
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public interface DAO {
	
	
	public <T> T executeCallback(Callback<T> callback) throws Exception;
	
	public int executeUpdate(String jpqlStmt);
	public int executeUpdate(String jpqlStmt,Map<String,Object> values) ;
	
	public int executeUpdateNamed(String namedQuery);
	public int executeUpdateNamed(String namedQuery,Map<String,Object> values) ;
	
	public <K extends Serializable,T extends AEntity<K>> T singleResult(Class<T> clazz,String jpqlStmt);
	public <K extends Serializable,T extends AEntity<K>> T singleResult(Class<T> clazz,String jpqlStmt,Map<String,Object> values);
	
	public <K extends Serializable,T extends AEntity<K>> T singleResultNamed(Class<T> clazz,String namedQuery);
	public <K extends Serializable,T extends AEntity<K>> T singleResultNamed(Class<T> clazz,String namedQuery,Map<String,Object> values);
	
	
	public Object singleResult(String jpqlStmt);
	public Object singleResult(String jpqlStmt,Map<String,Object> values) ;
	
	public Object singleResultNamed(String namedQuery);
	public Object singleResultNamed(String namedQuery,Map<String,Object> values) ;
	
	
	public <K extends Serializable,T extends AEntity<K>> Long count(Class<T> clazz);
	public <K extends Serializable,T extends AEntity<K>> List<T> find(Class<T> clazz);
	public <K extends Serializable,T extends AEntity<K>> List<T> find(Class<T> clazz,int firstResult,int maxResults) ;
	
	public <K extends Serializable,T extends AEntity<K>> List<T> find(Class<T> clazz,String jpqlStmt) ;
	public <K extends Serializable,T extends AEntity<K>> List<T> find(Class<T> clazz,String jpqlStmt,Map<String,Object> values);
	public <K extends Serializable,T extends AEntity<K>> List<T> find(Class<T> clazz,String jpqlStmt,int firstResult,int maxResults) ;
	public <K extends Serializable,T extends AEntity<K>> List<T> find(Class<T> clazz,String jpqlStmt,Map<String,Object> values,int firstResult,int maxResults);
	
	public <K extends Serializable,T extends AEntity<K>> List<T> findNamed(Class<T> clazz,String namedQuery) ;
	public <K extends Serializable,T extends AEntity<K>> List<T> findNamed(Class<T> clazz,String namedQuery,Map<String,Object> values);
	public <K extends Serializable,T extends AEntity<K>> List<T> findNamed(Class<T> clazz,String namedQuery,int firstResult,int maxResults) ;
	public <K extends Serializable,T extends AEntity<K>> List<T> findNamed(Class<T> clazz,String namedQuery,Map<String,Object> values,int firstResult,int maxResults);
	
	
	public int executeNativeUpdate(String sqlStmt, Object[] values);
	public int executeNativeUpdate(String sqlStmt,Map<String,Object> values) ;
	public List<?> findNative(String sqlStmt) ;
	public List<?> findNative(String sqlStmt,Object[] values);
	public List<?> findNative(String sqlStmt,List<?> values);
	
	public <K extends Serializable,T extends AEntity<K>> List<T> findNative(Class<T> clazz,String sqlStmt);
	public <K extends Serializable,T extends AEntity<K>> List<T> findNative(Class<T> clazz,String sqlStmt,Object[] values);
	public <K extends Serializable,T extends AEntity<K>> List<T> findNative(Class<T> clazz,String sqlStmt,List<?> values);
	
	
	public <K extends Serializable,T extends AEntity<K>> T persist(T entity,String username) ;
	public <K extends Serializable,T extends AEntity<K>> List<T> persistAll(List<T> entity,String username) ;
	
	public <K extends Serializable,T extends AEntity<K>> T detach(T entity) ;
	public <K extends Serializable,T extends AEntity<K>> List<T> detachAll(List<T> entity) ;
	
	public <K extends Serializable,T extends AEntity<K>> T merge(T entity,String username);
	public <K extends Serializable,T extends AEntity<K>> List<T> mergeAll(List<T> entity,String username);
	
	public <K extends Serializable,T extends AEntity<K>> T refresh(T entity);
	public <K extends Serializable,T extends AEntity<K>> List<T> refreshAll(List<T> entity);
	
	public <K extends Serializable,T extends AEntity<K>> T load(Class<T> clazz,K oid);
	public <K extends Serializable,T extends AEntity<K>> T load(T entity);

	public <K extends Serializable,T extends AEntity<K>> void remove(Class<T> clazz,K oid) ;
	public <K extends Serializable,T extends AEntity<K>> void remove(T entity);
	public <K extends Serializable,T extends AEntity<K>> void removeAll(List<T> list);

	
	
	

	
}

