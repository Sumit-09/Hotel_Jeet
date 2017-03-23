/*package com.hotel.jeet.MongoDb;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.pearson.platform.common.dataaccess.AbstractDataAccessAPI;
import com.pearson.platform.common.dataaccess.factory.DataAccessFactory.SupporedDatabase;
import com.pearson.platform.common.domain.model.BaseModel;
import com.pearson.platform.common.utils.exception.PlatformException;


@Service
@SuppressWarnings("rawtypes")
public class MongoDataAccessImpl extends AbstractDataAccessAPI {

	@Autowired
	MongoTemplate mongoTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<BaseModel> getFilteredResults(Class clazz, Map<String, Object> filterCriteria) {

		Query q = new Query();

		for (String key : filterCriteria.keySet()) { // NOSONAR
			q.addCriteria(Criteria.where(key).is(filterCriteria.get(key)));
		}

		return mongoTemplate.find(q, clazz);
	}

	@SuppressWarnings("unchecked")
	@Override
	public BaseModel getFilteredOneResult(Class clazz, Map<String, Object> filterCriteria) {

		Query q = new Query();

		for (String key : filterCriteria.keySet()) { // NOSONAR
			q.addCriteria(Criteria.where(key).is(filterCriteria.get(key)));
		}
		return (BaseModel) mongoTemplate.findOne(q, clazz);
	}

	@Override
	public void save(Object object) {
		mongoTemplate.save(object);
	}

	@Override
	public Integer count(Class clazz) {
		return getFilteredResults(clazz, null).size();
	}

	@Override
	public void remove(Object object) {
		mongoTemplate.remove(object);
	}

	@Override
	public void delete(Class clazz, Map<String, Object> filterCriteria) {

		Query q = new Query();

		for (String key : filterCriteria.keySet()) { // NOSONAR
			q.addCriteria(Criteria.where(key).is(filterCriteria.get(key)));
		}
		mongoTemplate.remove(q, clazz);
	}

	@Override
	public <T> List<T> persistAll(List<T> collectionOfObjects) {
		Iterator<T> itr = collectionOfObjects.iterator();
		while (itr.hasNext()) {
			mongoTemplate.save(itr.next());
		}
		return collectionOfObjects;
	}

	@Override
	public void deleteAll() throws PlatformException {
		throw new UnsupportedOperationException("Method Not Supported"); // NOSONAR
	}

	@Override
	public SupporedDatabase type() {
		return SupporedDatabase.MONGO;
	}

	@Override
	public List<BaseModel> getFilteredResults(Class clazz, Map<String, Object> filterCriteria, String orderBy,
			int limit, String orderByVariable) throws PlatformException {
		throw new UnsupportedOperationException("Method Not Supported");
	}

	@Override
	public Map getFilteredOneResult(Map<String, Object> filterCriteria) throws PlatformException {
		throw new UnsupportedOperationException("Method Not Supported");
	}

	@Override
	public void delete(String documentId) throws PlatformException {
		throw new UnsupportedOperationException("Method Not Supported");
	}

	@Override
	public List<Map> getFilteredResults(Map<String, Object> filterCriteria, String orderByVariable, String orderBy)
			throws PlatformException {
		throw new UnsupportedOperationException("Method Not Supported");
	}

	@Override
	public Map evaluateFunction(String code) throws PlatformException {
		return mongoTemplate.getDb().doEval(code);

	}
}
*/