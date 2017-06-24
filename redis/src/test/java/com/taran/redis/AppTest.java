package com.taran.redis;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.taran.redis.model.Customer;
import com.taran.redis.persistence.ConnectionPool;
import com.taran.redis.service.JedisPersistance;
import com.taran.redis.service.JedisPersistanceImpl;

/**
 * Unit test for simple App.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest {

	/** The jedis persistance. */
	private JedisPersistance<Customer> jedisPersistance;

	/**
	 * Create the test case.
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest() {
		jedisPersistance = new JedisPersistanceImpl<Customer>();
	}

	/**
	 * This is to test the application.
	 */
	@Test
	public void testApp() {
		Customer customer = this.buildMockCustomer();
		this.jedisPersistance.add(customer.getCustomerId(), customer);
		Customer sessionCustomer = this.jedisPersistance.get(customer.getCustomerId(), Customer.class);
		Assert.assertTrue("Taran".equals(sessionCustomer.getName()));
	}

	/**
	 * This test is used to test the connection to redis.
	 * 
	 * @author Taran
	 */
	@Test
	public void testConnect() {
		Assert.assertTrue(ConnectionPool.getConnection().isConnected());
	}

	/**
	 * Test flush key.
	 */
	@Test
	public void testFlushKey() {
		Customer customer = this.buildMockCustomer();
		Assert.assertTrue(1 == this.jedisPersistance.flushKey(customer.getCustomerId()));
	}

	/**
	 * Test flush all.
	 */
	@Test
	public void testFlushKeys() {
		Assert.assertTrue("OK".equals(this.jedisPersistance.flushall()));

	}

	/**
	 * Builds the mock customer.
	 *
	 * @return the customer
	 */
	private Customer buildMockCustomer() {
		return new Customer("1", "Taran");
	}

}
