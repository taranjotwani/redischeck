package com.taran.redis.persistence;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * The Class ConnectionPool.
 */
public class ConnectionPool {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(ConnectionPool.class);

	/** The connection. */
	private static Jedis connection;

	private static JedisPool jedisPool;

	static {
		LOGGER.info("Trying to connect to Redis");
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(10);
		jedisPool = new JedisPool(config, "127.0.0.1", 6379, 2000, "redis");
		if (jedisPool != null) {
			LOGGER.info("Connection was successful");
		} else {
			LOGGER.error("Failed to connect to the server");
		}
	}

	/**
	 * Gets the connection for jedis server.
	 *
	 * @return the connection
	 */
	public static Jedis getConnection() {
		connection = jedisPool.getResource();
		return connection;
	}

}
