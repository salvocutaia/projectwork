package it.eng.unipa.projectwork.dao.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
//import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.eng.unipa.projectwork.dao.Callback;
import it.eng.unipa.projectwork.dao.DAO;
import it.eng.unipa.projectwork.dao.InternalDAO;
import it.eng.unipa.projectwork.model.AEntity;

//import org.apache.commons.beanutils.PropertyUtils;

@Stateless
/*@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)*/
public class DAOImpl implements DAO,InternalDAO {

	//	@Inject @it.eng.ateso.astuto.be.framework.annotation.ClientSessionContext
	//	private ClientSessionContext context;

	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager=entityManager;
	}


	public DAOImpl() {
	}



	@Override
	public int executeUpdate(final String jpqlStmt){
		return executeUpdate(jpqlStmt, new HashMap<>());
	}
	
	@Override
	public int executeUpdateNamed(final String jpqlStmt){
		return executeUpdateNamed(jpqlStmt, new HashMap<>());
	}

	@Override
	public int executeUpdate(final String jpqlStmt,Map<String,Object> values) {
		return executeUpdate(true, jpqlStmt, values);
	}
	
	@Override
	public int executeUpdateNamed(String namedQuery,Map<String,Object> values) {
		return executeUpdate(true, namedQuery, values);
	}
	
	private int executeUpdate(boolean named,final String jpqlStmt,Map<String,Object> values) {
		final Query query = createQuery(named,jpqlStmt);
		setParam(values, query);
		return query.executeUpdate();
	}


	private void setParam(Map<String, Object> values, final Query query) {
		for(Entry<String, Object> entry : values.entrySet()){
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}

	public Object singleResult(String jpqlStmt){
		return singleResult(jpqlStmt, new HashMap<>());
	}
	
	@Override
	public Object singleResult(String jpqlStmt,Map<String,Object> values) {
		return singleResult(false, jpqlStmt, values);
	}
	
	
	public Object singleResultNamed(String namedQuery){
		return singleResultNamed(namedQuery, new HashMap<>());
	}
	
	
	
	
	@Override
	public Object singleResultNamed(String namedQuery,Map<String,Object> values) {
		return singleResult(true, namedQuery, values);
	}
	
	
	
	private Object singleResult(boolean named,String jpqlStmt,Map<String,Object> values) {
		final Query query = createQuery(named,jpqlStmt);
		setParam(values, query);
		return query.getSingleResult();
	}

	@Override
	public <K extends Serializable,T extends AEntity<K>> T singleResult(Class<T> clazz,String jpqlStmt) {
		return singleResult(clazz,jpqlStmt,new HashMap<>());
	}
	
	@Override
	public <K extends Serializable, T extends AEntity<K>> T singleResultNamed(Class<T> clazz, String namedQuery) {
		return singleResultNamed(clazz, namedQuery, new HashMap<>());
	}

	@Override
	public <K extends Serializable,T extends AEntity<K>> T singleResult(Class<T> clazz, String jpqlStmt,Map<String,Object> values) {
		return singleResult(false, clazz, jpqlStmt, values);
	}
	
	@Override
	public <K extends Serializable,T extends AEntity<K>> T singleResultNamed(Class<T> clazz, String jpqlStmt,Map<String,Object> values) {
		return singleResult(true, clazz, jpqlStmt, values);
	}
	
	
	private <K extends Serializable,T extends AEntity<K>> T singleResult(boolean named,Class<T> clazz, String jpqlStmt,Map<String,Object> values) {
		final Query query = createQuery(named,jpqlStmt);
		setParam(values, query);
		return (T)query.getSingleResult();
	}



	@Override
	public List<?> findNative(String sqlStmt) {
		return findNative(sqlStmt, new Object[]{});
	}
	@Override
	public List<?> findNative(String sqlStmt, List<?> values) {
		return findNative(sqlStmt, values.toArray());	
	}
	@Override
	public List<?> findNative(String sqlStmt, Object[] values) {
		final Query query = entityManager.createNativeQuery(sqlStmt);
		for(int i=0;i<values.length;i++){
			query.setParameter((i+1), values[i]);
		}
		return query.getResultList();	
	}

	@Override
	public <K extends Serializable,T extends AEntity<K>> List<T> findNative(Class<T> clazz,String sqlStmt) {
		return findNative(clazz, sqlStmt,new Object[]{});
	}
	@Override
	public <K extends Serializable,T extends AEntity<K>> List<T> findNative(Class<T> clazz,String sqlStmt, List<?> values) {
		return findNative(clazz, sqlStmt, values.toArray());
	}
	@Override
	public <K extends Serializable,T extends AEntity<K>> List<T> findNative(Class<T> clazz,String sqlStmt, Object[] values) {
		final Query query = entityManager.createNativeQuery(sqlStmt,clazz);
		for(int i=0;i<values.length;i++){
			query.setParameter((i+1), values[i]);
		}
		return (List<T>)query.getResultList();
	}


	@Override
	public int executeNativeUpdate(String sqlStmt,Object[] values) {
		final Query query = entityManager.createNativeQuery(sqlStmt);
		for(int i=0;i<values.length;i++){
			query.setParameter((i+1), values[i]);
		}
		return query.executeUpdate();
	}

	@Override
	public int executeNativeUpdate(String sqlStmt,Map<String,Object> values) {
		final Query query = entityManager.createNativeQuery(sqlStmt);
		setParam(values, query);
		return query.executeUpdate();
	}



	/**
	 * <p>Metodo per il salvataggio di nuove {@link AEntity}.<br/>
	 * Usare questo metodo come <b>INSERT</b>.</p>
	 * 
	 * <p>Setta automaticamente i dati di audit (dtaIns, utIns, dtaMod, utMod).</p> 
	 * 
	 * */
	@Override
	public <K extends Serializable,T extends AEntity<K>>  T persist(T entity,String username) {
		Date now = new Date();
		entity.setDateInsertion(now);
		entity.setUsernameInsertion(username);
		entity.setDateModification(now);
		entity.setUsernameModification(username);

		entityManager.persist(entity);
		return entity;
	}


	/**
	 * <p>Metodo per la modifica di {@link AEntity} esistenti.<br/>
	 * Usare questo metodo come <b>UPDATE</b>.</p>
	 * 
	 * <p>Setta automaticamente i dati di audit (dtaIns, utIns, dtaMod, utMod).</p>
	 * 
	 * */
	@Override
	public <K extends Serializable,T extends AEntity<K>>  T merge(final T entity,String username) {
		Date now = new Date();
		if(entity.getDateInsertion() == null){
			entity.setDateInsertion(now);
			entity.setUsernameInsertion(username);
		}
		entity.setDateModification(now);
		entity.setUsernameModification(username);

		entityManager.merge(entity);
		return entity;
	}

	/**
	 * <p>Metodo per la modifica di una lista di {@link AEntity} esistenti.<br/>
	 * Usare questo metodo come <b>UPDATE</b> di massa.</p>
	 * 
	 * <p>Setta automaticamente i dati di audit (dtaIns, utIns, dtaMod, utMod).</p> 
	 * 
	 * */
	@Override
	public <K extends Serializable,T extends AEntity<K>> List<T> mergeAll(final List<T> entities,String username){
		for(T entity : entities){
			this.merge(entity,username);
		}
		return entities;
	}

	@Override
	public <K extends Serializable,T extends AEntity<K>> T load(final Class<T> clazz,final K id){
		return entityManager.find(clazz, id);
	}

	public <K extends Serializable,T extends AEntity<K>> T load(T entity){
		return (T)load(entity.getClass(), entity.getOid());
	}


	/**
	 *
	 * @param <T> generic class to return
	 * @param clazz class object to return
	 * @param id unique identity for entity
	 * @return
	 */
	@Override
	public <K extends Serializable,T extends AEntity<K>> void remove(final Class<T> clazz,final K id) {
		final T entity = load(clazz,id);
		entityManager.remove(entity);
	}

	@Override
	public <K extends Serializable,T extends AEntity<K>> void remove(final T entity) {
		remove(entity.getClass(),entity.getOid());
	}

	@Override
	public <K extends Serializable,T extends AEntity<K>> void removeAll(final List<T> list) {
		for(T t:list){
			entityManager.remove(t);
		}
	}



	/**
	 *
	 * @param <T> generic class to return
	 * @param entity object to persist
	 * @return T
	 */
	@Override
	public <K extends Serializable,T extends AEntity<K>> T refresh(final T entity){
		entityManager.refresh(entity);
		return entity;
	}
	@Override
	public <K extends Serializable,T extends AEntity<K>> List<T> refreshAll(final List<T> entities){
		for(T entity : entities){
			entityManager.refresh(entity);
		}
		return entities;
	}

	/** <code>select o from ChecklistQuestionHelp o</code> */
	/**
	 *
	 * @param <T> generic class to return
	 * @param clazz class object to return
	 * @return java.util.List
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public <K extends Serializable,T extends AEntity<K>> List<T> find(final Class<T> clazz) {
		return find(clazz, 0,0);
	}

	
	@Override
	public <K extends Serializable,T extends AEntity<K>> Long count(final Class<T> clazz) {
		return ((Number)singleResult("select count(*) from "+clazz.getSimpleName()+" a")).longValue();
	}
	
	@Override
	public <K extends Serializable,T extends AEntity<K>> List<T> find(final Class<T> clazz,int firstResult,int maxResults) {
		return find(clazz, "select a from "+clazz.getSimpleName()+" a",firstResult,maxResults);
	}


	public <K extends Serializable,T extends AEntity<K>> List<T> find(final Class<T> clazz,final String jpqlStmt) {
		return find(clazz,jpqlStmt,new HashMap<>());
	}


	@Override
	public <K extends Serializable,T extends AEntity<K>> List<T> find(Class<T> clazz,String jpqlStmt,Map<String,Object> values) {
		return find(clazz, jpqlStmt, values,0,0);
	}

	@Override
	public <K extends Serializable,T extends AEntity<K>> List<T> find(Class<T> clazz,String jpqlStmt,int firstResult,int maxResults) {
		return find(clazz, jpqlStmt, new HashMap<>(),firstResult,maxResults);
	}

	@Override
	public <K extends Serializable,T extends AEntity<K>> List<T> find(Class<T> clazz,String jpqlStmt,Map<String,Object> values,int firstResult,int maxResults){
		return find(false,clazz, jpqlStmt, values, firstResult, maxResults);
	}



	@Override
	public <K extends Serializable, T extends AEntity<K>> List<T> findNamed(Class<T> clazz, String jpqlStmt) {
		return findNamed(clazz, jpqlStmt, new HashMap<>());
	}

	@Override
	public <K extends Serializable, T extends AEntity<K>> List<T> findNamed(Class<T> clazz, String jpqlStmt,int firstResult, int maxResults) {
		return findNamed(clazz, jpqlStmt,new HashMap<>(), firstResult, maxResults);
	}

	@Override
	public <K extends Serializable,T extends AEntity<K>> List<T> findNamed(Class<T> clazz,String jpqlStmt,Map<String,Object> values){
		return findNamed(clazz, jpqlStmt, values, 0,0);
	}

	@Override
	public <K extends Serializable,T extends AEntity<K>> List<T> findNamed(Class<T> clazz,String jpqlStmt,Map<String,Object> values,int firstResult,int maxResults){
		return find(true,clazz, jpqlStmt, values, firstResult, maxResults);
	}

	private <K extends Serializable,T extends AEntity<K>> List<T> find(boolean named,Class<T> clazz,String jpqlStmt,Map<String,Object> values,int firstResult,int maxResults){
		final Query query = createQuery(named,jpqlStmt);
		setParam(values, query);
		if(firstResult>0){
			query.setFirstResult(firstResult);
		}
		if(maxResults>0){
			query.setMaxResults(maxResults);
		}
		return query.getResultList();
	}


	private Query createQuery(boolean named,String jpqlStmt) {
		if(named){
			return entityManager.createNamedQuery(jpqlStmt);
		}else{
			return entityManager.createQuery(jpqlStmt);
		}
	}

	/**
	 * <p>Metodo per il salvataggio di una lista di nuove {@link AEntity}.<br/>
	 * Usare questo metodo come <b>INSERT</b> di massa.</p>
	 * 
	 * <p>Setta automaticamente i dati di audit (dtaIns, utIns, dtaMod, utMod).</p>
	 * 
	 * */
	public <K extends Serializable,T extends AEntity<K>> List<T> persistAll(final List<T> entities,String username) {
		for(T entity : entities){
			this.persist(entity,username);
		}
		return entities;
	}

	/**
	 *
	 * @return 
	 **/
	public void begin() {
		entityManager.getTransaction().begin();
	}

	/**
	 *
	 * @return 
	 **/
	public void end() {
		entityManager.getTransaction().commit();
	}


	@Override
	public <K extends Serializable,T extends AEntity<K>> T detach(T entity) {
		entityManager.detach(entity);
		return entity;
	}

	@Override
	public <K extends Serializable,T extends AEntity<K>> List<T> detachAll(List<T> entities) {
		for(T entity : entities){
			detach(entity);
		}
		return entities;
	}

	/**
	 *
	 * @return 
	 **/
	public void flush() {
		entityManager.flush();
	}

	/**
	 *
	 * @return 
	 **/
	public void close() {
		entityManager.clear();
		entityManager.close();
	}


	@Override
	public <T> T executeCallback(Callback<T> callback) throws Exception {
		return callback.execute(entityManager);
	}





}

