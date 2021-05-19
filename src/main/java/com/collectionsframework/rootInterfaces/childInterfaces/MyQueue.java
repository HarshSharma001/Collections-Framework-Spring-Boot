package com.collectionsframework.rootInterfaces.childInterfaces;

import com.collectionsframework.rootInterfaces.MyCollection;

public interface MyQueue extends MyCollection
{
	/**
	 * method - to remove and return the head of the queue
	 * @return Object type element
	 * @throws Exception No element found exception
	 */
	Object poll() throws Exception;
	
	/**
	 * method - to return the head of the queue
	 * @return Object type element
	 * @throws Exception No element found exception
	 */
	Object peek() throws Exception;
}
