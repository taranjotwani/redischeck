package com.taran.redis.service;

/**
 * The Interface JedisPersistance.
 *
 * @param <T> the generic type
 */
public interface JedisPersistance<T> {
	
	/**
	 * Adds the object to the redis cache.
	 *
	 * @param key the key
	 * @param object the object
	 */
	void add(String key, T object);
	
	/**
	 * Gets the object from the cache.
	 *
	 * @param key the key
	 * @param classType the class type
	 * @return the t
	 */
	T get(String key, Class<T> classType);
	
	/**
	 * Flushall keys from the cached memory.
	 *
	 * @return the string
	 * @author Taran
	 */
	String flushall();
	
	/**
	 * Flush key.
	 *
	 * @param key the key
	 * @return the long
	 * @author Taran
	 */
	Long flushKey(String key);
	
	/**
	 * Save the keys to the disk for loading them at a later point of time.
	 * 
	 * @author Taran
	 */
	void saveToDisk();
}
