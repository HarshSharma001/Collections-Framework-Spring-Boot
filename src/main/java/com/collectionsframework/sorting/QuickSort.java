package com.collectionsframework.sorting;

public class QuickSort {
	private String type;

	public QuickSort(String type) {
		this.type = type;
	}

	/**
	 * recursive method to sort array using quick sort algorithm
	 * 
	 * @param lowerBound - the starting point of the array
	 * @param upperBound - the ending point of the array
	 * @param array      - Object[] type array
	 * @throws Exception - Datatype of array isn't defined properly
	 */
	public void quickSort(int lowerBound, int upperBound, Object[] array) throws Exception {
		// Base Case
		if (lowerBound >= upperBound) {
			return;
		}
		Object pivot = array[upperBound];
		int pivotIndex = partitionArray(lowerBound, upperBound, array, pivot);
		quickSort(lowerBound, pivotIndex - 1, array);
		quickSort(pivotIndex + 1, upperBound, array);
	}

	/**
	 * method to partion the array based on the pivot element
	 * 
	 * @param lowerBound - the starting point of the array
	 * @param upperBound - the ending point of the array
	 * @param array      - Object[] type array
	 * @param pivot      - the element which we have to use to partion the array
	 * @return - positive integer value as pivot element index
	 * @throws Exception
	 */
	private int partitionArray(int lowerBound, int upperBound, Object[] array, Object pivot) throws Exception {
		int i = 0, j = 0;
		while (i <= upperBound) {
			if (type.equals("int") || type.equals("Integer")) {
				if ((int) array[i] > (int) pivot) {
					i++;
				} else if ((int) array[i] <= (int) pivot) {
					swapElements(i, j, array);
					i++;
					j++;
				}
			}

			else if (type.equalsIgnoreCase("string")) {
				if (pivot.toString().compareTo(array[i].toString()) < 0) {
					i++;
				} else if (pivot.toString().compareTo(array[i].toString()) >= 0) {
					swapElements(i, j, array);
					i++;
					j++;
				}
			}

			else if (type.equals("char") || type.equals("character")) {
				if (Character.getNumericValue((char) array[i]) > Character.getNumericValue((char) pivot)) {
					i++;
				} else if (Character.getNumericValue((char) array[i]) <= Character.getNumericValue((char) pivot)) {
					swapElements(i, j, array);
					i++;
					j++;
				}
			}

			else if (type.equals("long") || type.equals("Long")) {
				if ((long) array[i] > (long) pivot) {
					i++;
				} else if ((long) array[i] <= (long) pivot) {
					swapElements(i, j, array);
					i++;
					j++;
				}
			}

			else if (type.equals("float") || type.equals("Float")) {
				if ((float) array[i] > (float) pivot) {
					i++;
				} else if ((float) array[i] <= (float) pivot) {
					swapElements(i, j, array);
					i++;
					j++;
				}
			}

			else if (type.equals("double") || type.equals("Double")) {
				if ((double) array[i] > (double) pivot) {
					i++;
				} else if ((double) array[i] <= (double) pivot) {
					swapElements(i, j, array);
					i++;
					j++;
				}
			}

			else {
				throw new Exception("Invalid data type of array !");
			}
		}
		return j - 1;
	}

	/**
	 * method to swap elements of the array
	 * 
	 * @param index1 - index 1
	 * @param index2 - index 2
	 * @param array  - Object[] array
	 */
	private void swapElements(int index1, int index2, Object[] array) {
		Object temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		return;
	}
}
