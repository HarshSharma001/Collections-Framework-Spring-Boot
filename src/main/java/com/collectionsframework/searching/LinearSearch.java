package com.collectionsframework.searching;

public class LinearSearch {

	/**
	 * method to search an element into an array using linearSearch algorithm
	 * 
	 * @param element - the element which needs to be searched
	 * @param array   - the array from which the elements need to be searched
	 * @return return positive index value if element is found else -1
	 */
	public int search(Object element, int currentSize, Object[] array) {
		//Base Case
		if(currentSize == 0) {
			return -1;
		}
		for (int i = 0; i < currentSize; i++) {
			if (array[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}
}
