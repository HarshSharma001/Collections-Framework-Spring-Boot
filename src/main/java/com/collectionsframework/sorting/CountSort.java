package com.collectionsframework.sorting;

public class CountSort {
	private String type;
	private Object min, max;

	/**
	 * constructor to initialize the type value for current object
	 * 
	 * @param type - String type
	 */
	public CountSort(String type) {
		this.type = type;
	}

	/**
	 * method to sort the provided array elements using CountSort algorithm
	 * 
	 * @param array - the original array
	 * @return Object[] array
	 * @throws Exception Array datatype can't be determined !
	 */
	public Object[] countSort(Object[] array) throws Exception {
		findMinMax(array);
		Object[] freqArr = null;
		if (type.equals("int") || type.equals("Integer")) {
			// filling the frequency array
			freqArr = new Object[(int) max - (int) min + 1];
			for (Object i : array) {
				int index = (int) i - (int) min;
				if (freqArr[index] == null) {
					freqArr[index] = 1;
				} else {
					freqArr[index] = (int) freqArr[index] + 1;
				}
			}

			// converting freqArr into prefix sum array
			int sum = 0;
			for (int i = 0; i < freqArr.length; i++) {
				if (freqArr[i] == null) {
					throw new Exception("The array can't be sorted with stability !");
				}
				sum = sum + (int) freqArr[i];
				freqArr[i] = sum - 1; // decrementing all indexes by 1
			}

			Object ansArray[] = new Object[array.length];
			for (int i = array.length - 1; i >= 0; i--) {
				int elementIndex = (int) array[i] - (int) min;
				int corectPosition = (int) freqArr[elementIndex];
				ansArray[corectPosition] = array[i];
				freqArr[elementIndex] = (int) freqArr[elementIndex] - 1;
			}

			return ansArray;
		}

		else if (type.equals("char") || type.equals("Character")) {
			freqArr = new Object[Character.getNumericValue((char) max) - Character.getNumericValue((char) min) + 1];
			// filling the frequency array
			for (Object i : array) {
				int index = Character.getNumericValue((char) i) - Character.getNumericValue((char) min);
				if (freqArr[index] == null) {
					freqArr[index] = 1;
				} else {
					freqArr[index] = (int) freqArr[index] + 1;
				}
			}

			// converting freqArr into prefix sum array
			int sum = 0;
			for (int i = 0; i < freqArr.length; i++) {
				if (freqArr[i] == null) {
					throw new Exception("The array can't be sorted with stability !");
				}
				sum = sum + (int) freqArr[i];
				freqArr[i] = sum - 1; // decrementing all indexes by 1
			}

			Object ansArray[] = new Object[array.length];
			for (int i = array.length - 1; i >= 0; i--) {
				int elementIndex = Character.getNumericValue((char) array[i]) - Character.getNumericValue((char) min);
				int corectPosition = (int) freqArr[elementIndex];
				ansArray[corectPosition] = array[i];
				freqArr[elementIndex] = (int) freqArr[elementIndex] - 1;
			}

			return ansArray;

		}

		else if (type.equals("long") || type.equals("Long")) {
			freqArr = new Object[(int) max - (int) min + 1];
			// filling the frequency array
			freqArr = new Object[(int) max - (int) min + 1];
			for (Object i : array) {
				int index = (int) i - (int) min;
				if (freqArr[index] == null) {
					freqArr[index] = 1;
				} else {
					freqArr[index] = (int) freqArr[index] + 1;
				}
			}

			// converting freqArr into prefix sum array
			int sum = 0;
			for (int i = 0; i < array.length; i++) {
				if (freqArr[i] == null) {
					throw new Exception("The array can't be sorted with stability !");
				}
				sum = sum + (int) array[i];
				array[i] = sum - 1; // decrementing all indexes by 1
			}

			Object ansArray[] = new Object[array.length];
			for (int i = array.length - 1; i >= 0; i--) {
				int elementIndex = (int) array[i] - (int) min;
				int corectPosition = (int) freqArr[elementIndex];
				ansArray[corectPosition] = array[i];
				freqArr[elementIndex] = (int) freqArr[elementIndex] - 1;
			}

			return ansArray;
		}

		else {
			throw new Exception("The array datatype can't be determined");
		}
	}

	/**
	 * method to return minimum and mximum values from the array
	 * 
	 * @param array - the original array
	 * @throws Exception The array datatype can't be determined
	 */
	private void findMinMax(Object[] array) throws Exception {
		min = array[0];
		max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (type.equals("int") || type.equals("Integer")) {
				if ((int) array[i] > (int) max) {
					max = array[i];
				}
				if ((int) array[i] < (int) min) {
					min = array[i];
				}
			}

			else if (type.equalsIgnoreCase("string")) {
				if (max.toString().compareTo(array[i].toString()) < 0) {
					max = array[i];
				}
				if (min.toString().compareTo(array[i].toString()) > 0) {
					min = array[i];
				}
			}

			else if (type.equals("char") || type.equals("character")) {
				if (Character.getNumericValue((char) array[i]) > Character.getNumericValue((char) max)) {
					max = array[i];
				}
				if (Character.getNumericValue((char) array[i]) < Character.getNumericValue((char) min)) {
					min = array[i];
				}
			}

			else if (type.equals("long") || type.equals("Long")) {
				if ((long) array[i] > (long) max) {
					max = array[i];
				}
				if ((long) array[i] < (long) min) {
					min = array[i];
				}
			}

			else if (type.equals("float") || type.equals("Float")) {
				if ((float) array[i] > (float) max) {
					max = array[i];
				}
				if ((float) array[i] < (float) min) {
					min = array[i];
				}
			}

			else if (type.equals("double") || type.equals("Double")) {
				if ((double) array[i] > (double) max) {
					max = array[i];
				}
				if ((double) array[i] < (double) min) {
					min = array[i];
				}
			}

			else {
				throw new Exception("Invalid data type of array !");
			}
		}
	}
}
