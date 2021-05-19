package com.collectionsframework.rootInterfaces.childInterfaces;

import com.collectionsframework.rootInterfaces.MyCollection;

public interface MySet extends MyCollection {
	/**
	 * meythod to find union of the current set and the provided set
	 * @param set An instance of set data structure
	 * @return Object type array
	 */
	Object[] findUnion(MySet set);
	
	/**
	 * method to find intersection of the current set and the provided set
	 * @param set
	 * @return
	 */
	Object[] findIntersection(MySet set);
	
	/**
	 * method to get Object type element present at the specified index in MyList
	 * 
	 * @param index integer value representing as index
	 * @return returns Object type element
	 */
	Object get(int index);

	/**
	 * method to get the first occurence of the specified element from MyList
	 * 
	 * @param o the object type element to get first occurence index of
	 * @return return positive integer value index if the element is present else -1
	 */
	int indexOf(Object o);

	/**
	 * method to get the last occurence of the specified element from MyList
	 * 
	 * @param o - the object type element to get last occurence index of
	 * @return return positive integer value as index if the element is present else
	 *         -1
	 */
	int lastIndexOf(Object o);

	/**
	 * method to remove element specified at the index from MyList
	 * 
	 * @param index - integer value as index;
	 */
	void remove(int index) throws Exception;

	/**
	 * method to set/replaces specified element at specified index in MyList
	 * 
	 * @param index the integer index
	 * @param o     - the element to set
	 */
	void set(int index, Object o) throws Exception;

	/**
	 * method to get a sub MyList with specified indexes from the parent MyList
	 * 
	 * @param fromIndex - the starting index including
	 * @param toIndex   - the ending index including
	 * @return returns Object[] instance
	 */
	Object[] subList(int fromIndex, int toIndex);
}
