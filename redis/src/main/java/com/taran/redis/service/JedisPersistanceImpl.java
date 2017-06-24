package com.taran.redis.service;

import com.google.gson.Gson;
import com.taran.redis.persistence.ConnectionPool;

import redis.clients.jedis.Jedis;

/**
 * The Class JedisPersistanceImpl.
 *
 * @param <T>
 *            the generic type
 */
public class JedisPersistanceImpl<T> implements JedisPersistance<T> {

	/** The jedis. */
	private Jedis jedis;

	/** The gson. */
	private Gson gson;

	/**
	 * Instantiates a new jedis persistance impl.
	 */
	public JedisPersistanceImpl() {
		jedis = ConnectionPool.getConnection();
		gson = new Gson();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.taran.redis.service.JedisPersistance#add(java.lang.String,
	 * java.lang.Object)
	 */
	public void add(String key, T value) {
		String jsonValue = gson.toJson(value);
		jedis.set(key, jsonValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.taran.redis.service.JedisPersistance#get(java.lang.String)
	 */
	public T get(String key, final Class<T> classType) {
		String value = jedis.get(key);
		return (T) gson.fromJson(value, classType);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.taran.redis.service.JedisPersistance#flushall()
	 */
	public String flushall() {
		return jedis.flushAll();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.taran.redis.service.JedisPersistance#flushKey(java.lang.String)
	 */
	public Long flushKey(String key) {
		return jedis.del(key);
	}

	/* (non-Javadoc)
	 * @see com.taran.redis.service.JedisPersistance#saveToDisk()
	 */
	public void saveToDisk() {
		this.jedis.save();
	}

}
