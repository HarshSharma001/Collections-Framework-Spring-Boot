package com.collectionsframework.searching;

public class BinarySearch {

	/**
	 * method to search an element into an array using binarySearch algorithm
	 * 
	 * @param element - the element which needs to be searched
	 * @param array   - the array from which the elements need to be searched
	 * @param type    - the array data-type
	 * @return return positive index value if element is found else -1
	 * @throws Exception Array datatype exception
	 */
	public int search(Object element, int currentSize, Object[] array, String type) throws Exception {
		//Base Case
		if(currentSize == 0) {
			return -1;
		}
		
		int beg = 0, end = currentSize - 1;
		int mid = (beg + end) / 2;
		while (beg <= mid && array[mid] != element) {
			if (type.equals("int") || type.equals("Integer")) {
				if ((int) element < (int) array[mid]) {
					end = mid - 1;
				} else if ((int) element > (int) array[mid]) {
					beg = mid + 1;
				}
				mid = (beg + end) / 2;
			}

			else if (type.equalsIgnoreCase("string")) {
				if (element.toString().compareTo(array[mid].toString()) < 0) {
					end = mid - 1;
				} else if (array[mid].toString().compareTo(element.toString()) < 0) {
					beg = mid + 1;
				}
				mid = (beg + end) / 2;
			}

			else if (type.equals("char") || type.equals("character")) {
				if (Character.getNumericValue((char) element) < Character.getNumericValue((char) array[mid])) {
					end = mid - 1;
				} else if (Character.getNumericValue((char) element) > Character.getNumericValue((char) array[mid])) {
					beg = mid + 1;
				}
				mid = (beg + end) / 2;
			}

			else if (type.equals("long") || type.equals("Long")) {
				if ((long) element < (long) array[mid]) {
					end = mid - 1;
				} else if ((long) element > (long) array[mid]) {
					beg = mid + 1;
				}
				mid = (beg + end) / 2;
			}

			else if (type.equals("float") || type.equals("Float")) {
				if ((float) element < (float) array[mid]) {
					end = mid - 1;
				} else if ((float) element > (float) array[mid]) {
					beg = mid + 1;
				}
				mid = (beg + end) / 2;
			}

			else if (type.equals("double") || type.equals("Double")) {
				if ((double) element < (double) array[mid]) {
					end = mid - 1;
				} else if ((double) element > (double) array[mid]) {
					beg = mid + 1;
				}
				mid = (beg + end) / 2;
			}

			else {
				throw new Exception("Invalid data type of array !");
			}
		}

		if (array[mid] == element) {
			return mid;
		} else {
			return -1;
		}
	}
}
