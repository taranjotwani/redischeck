package com.taran.redis.model;

import java.io.Serializable;

/**
 * The customer class is a sample class to be tested to be cached into redis.
 * This class will be having multiple data structures to be stored and restored
 * when needed.
 * 
 * @author Taran
 */
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Customer(String id, String name) {
		this.customerId = id;
		this.name = name;
	}

	/** The customer id. */
	private String customerId;

	/** The name. */
	private String name;

	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the customer id.
	 *
	 * @param customerId
	 *            the new customer id
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [getCustomerId()=");
		builder.append(getCustomerId());
		builder.append(", getName()=");
		builder.append(getName());
		builder.append("]");
		return builder.toString();
	}
}
