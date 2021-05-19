package com.collectionsframework.sorting;

public class MergeSort {
	private String type;

	public MergeSort(String type) {
		this.type = type;
	}

	public Object[] mergeSort(int lowerBound, int upperBound, Object[] array) throws Exception {
		// Base Case
		if (lowerBound == upperBound) {
			Object[] baseCaseArray = new Object[1];
			baseCaseArray[0] = array[lowerBound];
			return baseCaseArray;
		}

		int mid = (lowerBound + upperBound) / 2;
		Object[] firstHalf = mergeSort(lowerBound, mid, array);
		Object[] secondHalf = mergeSort(mid + 1, upperBound, array);

		Object[] output = mergeTwoArrays(firstHalf, secondHalf);
		return output;
	}

	private Object[] mergeTwoArrays(Object[] array1, Object[] array2) throws Exception {
		int i = 0, j = 0, k = 0;
		Object[] array = new Object[array1.length + array2.length];

		while (i < array1.length || j < array2.length) {
			// if array1 is already ended
			if (i >= array1.length && j < array2.length) {
				array[k] = array2[j];
				j++;
				k++;
			}

			// if array2 is ended already
			else if (j >= array2.length && i < array1.length) {
				array[k] = array1[i];
				i++;
				k++;
			}

			else {
				if (type.equals("int") || type.equals("Integer")) {
					if ((int) array1[i] <= (int) array2[j]) {
						array[k] = array1[i];
						i++;
						k++;
					} else if ((int) array2[j] < (int) array1[i]) {
						array[k] = array2[j];
						j++;
						k++;
					}
				}

				else if (type.equalsIgnoreCase("string")) {
					Object max = getMax(array1[i].toString(), array2[j].toString());
					if (max.equals(array1[i])) {
						array[k] = array2[j];
						k++;
						j++;
					} else {
						array[k] = array1[i];
						k++;
						i++;
					}
				}

				else if (type.equals("char") || type.equals("character")) {
					Object max = getMax((char) array1[i], (char) array2[j]);
					if (max.equals(array1[i])) {
						array[k] = array2[j];
						k++;
						j++;
					} else {
						array[k] = array1[i];
						k++;
						i++;
					}
				}

				else if (type.equals("long") || type.equals("Long")) {
					Object max = getMax((long) array1[i], (long) array2[j]);
					if (max.equals(array1[i])) {
						array[k] = array2[j];
						k++;
						j++;
					} else {
						array[k] = array1[i];
						k++;
						i++;
					}
				}

				else if (type.equals("float") || type.equals("Float")) {
					Object max = getMax((float) array1[i], (float) array2[j]);
					if (max.equals(array1[i])) {
						array[k] = array2[j];
						k++;
						j++;
					} else {
						array[k] = array1[i];
						k++;
						i++;
					}
				}

				else if (type.equals("double") || type.equals("Double")) {
					Object max = getMax((double) array1[i], (double) array2[j]);
					if (max.equals(array1[i])) {
						array[k] = array2[j];
						k++;
						j++;
					} else {
						array[k] = array1[i];
						k++;
						i++;
					}
				}

				else {
					throw new Exception("Invalid data type of array !");
				}
			}
		}
		return array;
	}

	/**
	 * method to get int maximum value of 2 int values
	 * 
	 * @param num1
	 * @param num2
	 * @return an integer values
	 */
	private int getMax(int num1, int num2) {
		if (num1 > num2)
			return num1;
		else
			return num2;
	}

	/**
	 * method to get maximum String lexicographically of 2 strings
	 * 
	 * @param s1 - the string 1
	 * @param s2 - the string 2
	 * @return a string value
	 */
	private String getMax(String s1, String s2) {
		if (s1.compareTo(s2) < 0)
			return s2;
		else
			return s1;
	}

	/**
	 * method to get the maximum character value of 2 character
	 * 
	 * @param c1 - character 1
	 * @param c2 - character 2
	 * @return a character value
	 */
	private char getMax(char c1, char c2) {
		if (Character.getNumericValue(c1) > Character.getNumericValue(c2))
			return c1;
		else
			return c2;
	}

	/**
	 * method to get the maximum double value of 2 character
	 * 
	 * @param c1 - double 1
	 * @param c2 - double 2
	 * @return a double value
	 */
	private double getMax(double num1, double num2) {
		if (num1 > num2)
			return num1;
		else
			return num2;
	}

	/**
	 * method to get the maximum float value of 2 character
	 * 
	 * @param c1 - float 1
	 * @param c2 - float 2
	 * @return a float value
	 */
	private float getMax(float num1, float num2) {
		if (num1 > num2)
			return num1;
		else
			return num2;
	}

	/**
	 * method to get the maximum long value of 2 character
	 * 
	 * @param c1 - long 1
	 * @param c2 - long 2
	 * @return a long value
	 */
	private long getMax(long num1, long num2) {
		if (num1 > num2)
			return num1;
		else
			return num2;
	}
}
