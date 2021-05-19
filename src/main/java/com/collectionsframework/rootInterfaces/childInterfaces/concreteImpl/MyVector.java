package com.collectionsframework.rootInterfaces.childInterfaces.concreteImpl;

import com.collectionsframework.rootInterfaces.MyCollection;
import com.collectionsframework.rootInterfaces.childInterfaces.MyList;
import com.collectionsframework.searching.BinarySearch;
import com.collectionsframework.searching.LinearSearch;
import com.collectionsframework.sorting.CountSort;
import com.collectionsframework.sorting.MergeSort;
import com.collectionsframework.sorting.QuickSort;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "singleton")
public class MyVector implements MyList {
	private Object[] array;
	private String type = null;
	private int currentSize = 0;
	private boolean isSorted = false;

	private QuickSort qSort;
	private MergeSort mSort;
	private CountSort cSort;

	private BinarySearch binarySearch;
	private LinearSearch linearSearch;

	/**
	 * constructor to initialize the array with the specified type
	 * 
	 * @param type - the data type of the array
	 */
	public MyVector(String type) {
		this.type = type;
		qSort = new QuickSort(type);
		mSort = new MergeSort(type);
		cSort = new CountSort(type);
		binarySearch = new BinarySearch();
		linearSearch = new LinearSearch();

		if (type.equals("int") || type.equals("Integer")) {
			array = new Integer[1];
		} else if (type.equals("string") || type.equals("String")) {
			array = new String[1];
		} else if (type.equals("char") || type.equals("Character")) {
			array = new Character[1];
		} else if (type.equalsIgnoreCase("double")) {
			array = new Double[1];
		} else if (type.equalsIgnoreCase("float")) {
			array = new Float[1];
		} else if (type.equalsIgnoreCase("long")) {
			array = new Long[1];
		} else {
			array = new Object[1];
		}
	}

	/**
	 * method to print provided array
	 * 
	 * @param argArray - to be printed
	 */
	public synchronized void printArray(Object[] argArray) {
		System.out.print("[");
		for (int i = 0; i < argArray.length; i++) {
			if (i < argArray.length - 1) {
				System.out.print(argArray[i] + ", ");
			} else if (i == argArray.length - 1) {
				System.out.print(argArray[i]);
			}
		}
		System.out.print("]");
		System.out.println();
	}

	/**
	 * method to copy old array elements into the array with the lastest element as
	 * well
	 * 
	 * @param tempArr - the old array elements
	 * @param array   - the current empty array
	 * @param o       - the object type data element to be inserted into the array
	 * @return returns Object[] array
	 */
	private synchronized Object[] copyOldArrayElementsWithNewElement(Object[] tempArr, Object[] array, Object o) {
		int i = 0;
		for (i = 0; i < tempArr.length && tempArr[i] != null; i++) {
			array[i] = tempArr[i];
		}
		array[i] = o;
		currentSize = i + 1;
		if (currentSize >= 2) {
			updateSortingStatus(i - 1, i, type, array);
		}

		return array;
	}

	/**
	 * method to check-update, if the list is sorted or not
	 * 
	 * @param i     - the last added element into the array previously
	 * @param j     - the newest element added into the array currently
	 * @param type  - the array datatype
	 * @param array - the original array
	 */
	private synchronized void updateSortingStatus(int i, int j, String type, Object[] array) {
		if (type.equals("int") || type.equals("Integer")) {
			if ((int) array[i] <= (int) array[j]) {
				isSorted = true;
			} else
				isSorted = false;
		} else if (type.equals("char") || type.equals("Character")) {
			if (Character.getNumericValue((char) array[i]) <= Character.getNumericValue((char) array[j])) {
				isSorted = true;
			} else
				isSorted = false;
		} else if (type.equalsIgnoreCase("String")) {
			if (String.valueOf(array[i]).compareTo(array[j].toString()) <= 0) {
				isSorted = true;
			} else
				isSorted = false;
		} else if (type.equalsIgnoreCase("double")) {
			if ((double) array[i] <= (double) array[j]) {
				isSorted = true;
			} else
				isSorted = false;
		} else if (type.equalsIgnoreCase("float")) {
			if ((float) array[i] <= (float) array[j]) {
				isSorted = true;
			} else
				isSorted = false;
		} else if (type.equalsIgnoreCase("long")) {
			if ((long) array[i] <= (long) array[j]) {
				isSorted = true;
			} else
				isSorted = false;
		}
	}

	/**
	 * method to save current array elements into a temporary array
	 * 
	 * @param array the original which elements need to be saved
	 * @return Object[] array
	 */
	private synchronized Object[] saveArrayELements(Object[] array) {
		Object[] temp = new Object[array.length];
		for (int i = 0; i < array.length && array[i] != null; i++) {
			temp[i] = array[i];
		}
		return temp;
	}

	/**
	 * method to increase size by doubling the length of the array and return it
	 * 
	 * @param array - the array who's size need to be extended
	 * @return Object[] array with no elements in it
	 */
	private synchronized Object[] increaseSize(Object[] array) {
		if (type.equals("int") || type.equals("Integer")) {
			array = new Integer[array.length * 2];
		} else if (type.equals("string") || type.equals("String")) {
			array = new String[array.length * 2];
		} else if (type.equals("char") || type.equals("Character")) {
			array = new Character[array.length * 2];
		} else if (type.equalsIgnoreCase("double")) {
			array = new Double[array.length * 2];
		} else if (type.equalsIgnoreCase("float")) {
			array = new Float[array.length * 2];
		} else if (type.equalsIgnoreCase("long")) {
			array = new Long[array.length * 2];
		} else {
			array = new Object[array.length * 2];
		}
		return array;
	}

	/**
	 * public method to print the dynamic array from outside
	 */
	public synchronized void print() {
		System.out.print("[");
		for (int i = 0; i < currentSize; i++) {
			if (i < currentSize - 1) {
				System.out.print(array[i] + ", ");
			} else if (i == currentSize - 1) {
				System.out.print(array[i]);
			}
		}
		System.out.print("]");
		System.out.println();
	}

	/**
	 * method to sort the arraylist
	 * 
	 * @throws Exception - The array datatype can't be determined
	 */
	public synchronized void sort() throws Exception {
		Object[] tempArr = new Object[currentSize];
		for (int i = 0; i < tempArr.length; i++) {
			tempArr[i] = array[i];
		}

		if (array.length <= 100000) {
			qSort.quickSort(0, tempArr.length - 1, tempArr);
			array = tempArr;
			isSorted = true;
			return;
		} else {
			array = mSort.mergeSort(0, tempArr.length - 1, tempArr);
			isSorted = true;
			return;
		}
	}

	/**
	 * method to sort the arraylist elements with stability
	 * 
	 * @throws Exception - The array datatype can't be determined
	 */
	public synchronized void sortWithStabilty() throws Exception {
		Object[] tempArr = new Object[currentSize];
		for (int i = 0; i < tempArr.length; i++) {
			tempArr[i] = array[i];
		}
		array = cSort.countSort(tempArr);
		isSorted = true;
		return;
	}

	public synchronized boolean isSorted() {
		return isSorted;
	}

	private synchronized void updateSortingStatusAfterReplacement(int left, int mid, int right, Object[] array, String type) {
		if (type.equals("int") || type.equals("Integer")) {
			// left boundary not crossed yet
			if (mid - 1 >= 0) {
				if ((int) array[left] <= (int) array[mid] && isSorted) {
					isSorted = true;
				}
			}
			// right boundary not crossed yet
			if (mid < currentSize - 1) {
				if ((int) array[mid] <= (int) array[right] && isSorted) {
					isSorted = true;
				}
			} else {
				isSorted = false;
			}
		}

		else if (type.equals("char") || type.equals("Character")) {
			// left boundary not crossed yet
			if (mid - 1 >= 0) {
				if (Character.getNumericValue((char) array[left]) <= Character.getNumericValue((char) array[mid])
						&& isSorted) {
					isSorted = true;
				}
			}
			// right boundary not crossed yet
			if (mid < currentSize - 1) {
				if (Character.getNumericValue((char) array[mid]) <= Character.getNumericValue((char) array[right])
						&& isSorted) {
					isSorted = true;
				}
			} else {
				isSorted = false;
			}
		}

		else if (type.equalsIgnoreCase("String")) {
			// left boundary not crossed yet
			if (mid - 1 >= 0) {
				if (array[left].toString().compareTo(array[mid].toString()) <= 0 && isSorted) {
					isSorted = true;
				}
			}
			// right boundary not crossed yet
			if (mid < currentSize - 1) {
				if (array[mid].toString().compareTo(array[right].toString()) <= 0 && isSorted) {
					isSorted = true;
				}
			} else {
				isSorted = false;
			}

		} else if (type.equalsIgnoreCase("long")) {
			// left boundary not crossed yet
			if (mid - 1 >= 0) {
				if ((long) array[left] <= (long) array[mid] && isSorted) {
					isSorted = true;
				}
			}
			// right boundary not crossed yet
			if (mid < currentSize - 1) {
				if ((long) array[mid] <= (long) array[right] && isSorted) {
					isSorted = true;
				}
			} else {
				isSorted = false;
			}
		} else if (type.equalsIgnoreCase("double")) {
			// left boundary not crossed yet
			if (mid - 1 >= 0) {
				if ((double) array[left] <= (double) array[mid] && isSorted) {
					isSorted = true;
				}
			}
			// right boundary not crossed yet
			if (mid < currentSize - 1) {
				if ((double) array[mid] <= (double) array[right] && isSorted) {
					isSorted = true;
				}
			} else {
				isSorted = false;
			}
		}

		else if (type.equalsIgnoreCase("float")) {
			// left boundary not crossed yet
			if (mid - 1 >= 0) {
				if ((float) array[left] <= (float) array[mid] && isSorted) {
					isSorted = true;
				}
			}
			// right boundary not crossed yet
			if (mid < currentSize - 1) {
				if ((float) array[mid] <= (float) array[right] && isSorted) {
					isSorted = true;
				}
			} else {
				isSorted = false;
			}
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public synchronized String getType() {
		return this.type;
	}

	@Override
	public synchronized int size() {
		return currentSize;
	}

	@Override
	public synchronized void add(Object o) {
		Object[] tempArr = saveArrayELements(array);
		array = increaseSize(array);
		array = copyOldArrayElementsWithNewElement(tempArr, array, o);
	}

	@Override
	public synchronized void remove(Object o) throws Exception {
		if (isSorted) {
			int location = binarySearch.search(o, currentSize, array, type);
			if (location == -1) {
				System.out.println();
				throw new Exception("The specified object isn't present in the arraylist");
			} else {
				int index = 0;
				Object[] ansArray = new Object[array.length - 1];
				for (int i = 0; i < currentSize; i++) {
					if (i != location) {
						ansArray[index] = array[i];
						index += 1;
					}
				}
				currentSize = index;
				isSorted = true;
				array = ansArray;
			}
		}

		else {
			int location = linearSearch.search(o, currentSize, array);
			if (location == -1) {
				System.out.println();
				throw new Exception("The specified object isn't present in the arraylist");
			} else {
				int index = 0;
				Object[] ansArray = new Object[array.length - 1];
				for (int i = 0; i < currentSize; i++) {
					if (location != i) {
						ansArray[index] = array[i];
						index = index + 1;
					}
				}
				currentSize = index;
				isSorted = false;
				array = ansArray;
			}
		}
	}

	@Override
	public synchronized void removeAll(MyCollection mc) {
		int size = 0;
		Object[] tempArr = mc.toArray();
		if (isSorted) {
			for (int i = 0; i < tempArr.length; i++) {
				try {
					int location = binarySearch.search(tempArr[i], currentSize, array, type);
					if (location != -1)
						size++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else if (!isSorted) {
			for (int i = 0; i < tempArr.length; i++) {
				for (int j = 0; j < currentSize; j++) {
					if (tempArr[i].equals(array[j])) {
						size++;
					}
				}
			}
		}

		if (size > 0) {
			Object[] ansArr = new Object[currentSize - size];
			int index = 0;
			boolean found = false;
			for (int i = 0; i < currentSize; i++) {
				for (int j = 0; j < tempArr.length; j++) {
					if (array[i].equals(tempArr[j])) {
						found = true;
						break;
					}
				}
				if (!found) {
					ansArr[index] = array[i];
					index++;
				}
				found = false;
			}
			isSorted = false;
			currentSize = index;
			array = ansArr;
		}
	}

	@Override
	public synchronized boolean isEmpty() {
		if (currentSize == 0)
			return true;
		else
			return false;
	}

	@Override
	public synchronized boolean contains(Object o) {
		if (!isSorted) {
			if (linearSearch.search(o, currentSize, array) == -1) {
				return false;
			} else {
				return true;
			}
		} else {
			try {
				if (binarySearch.search(o, currentSize, array, type) == -1) {
					return false;
				} else {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public synchronized boolean containsAll(MyCollection mc) {
		// TODO Auto-generated method stub
		String mcType = mc.getType();
		if (!mcType.equals("Integer") && mcType.equals("Character") && !mcType.equalsIgnoreCase(type)) {
			System.out.println("Error : type mismatch of the provided collections !");
			return false;
		}

		if (isSorted) {
			Object[] tempArr = mc.toArray();
			for (Object o : tempArr) {
				try {
					int location = binarySearch.search(o, currentSize, array, type);
					if (location == -1) {
						return false;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return true;
		}

		else {
			Object[] tempArr = mc.toArray();
			for (Object o : tempArr) {
				int location = linearSearch.search(o, currentSize, array);
				if (location == -1) {
					return false;
				}
			}
			return true;
		}
	}

	@Override
	public synchronized void clear() {
		isSorted = false;
		currentSize = 0;
		if (type.equals("int") || type.equals("Integer")) {
			array = new Integer[1];
		} else if (type.equals("string") || type.equals("String")) {
			array = new String[1];
		} else if (type.equals("char") || type.equals("Character")) {
			array = new Character[1];
		} else if (type.equalsIgnoreCase("double")) {
			array = new Double[1];
		} else if (type.equalsIgnoreCase("float")) {
			array = new Float[1];
		} else if (type.equalsIgnoreCase("long")) {
			array = new Long[1];
		} else {
			array = new Object[1];
		}
	}

	@Override
	public synchronized Object max() throws Exception {
		// TODO Auto-generated method stub
		if (type.equals("int") || type.equals("Integer")) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < currentSize; i++) {
				int element = (int) array[i];
				if (element > max) {
					max = element;
				}
			}
			return max;
		}

		else if (type.equals("string") || type.equals("String")) {
			String max = "";
			for (int i = 0; i < currentSize; i++) {
				String element = array[i].toString();
				if (max.compareTo(element) < 0) {
					max = element;
				}
			}
			return max;
		}

		else if (type.equals("char") || type.equals("Character")) {
			char max = (char) array[0];
			for (int i = 1; i < currentSize; i++) {
				char c = (char) array[i];
				if (Character.getNumericValue(c) > Character.getNumericValue(max)) {
					max = c;
				}
			}
			return max;
		}

		else if (type.equalsIgnoreCase("double")) {
			double max = Double.MIN_VALUE;
			for (int i = 0; i < currentSize; i++) {
				double element = (double) array[i];
				if (element > max) {
					max = element;
				}
			}
			return max;
		}

		else if (type.equalsIgnoreCase("float")) {
			float max = Float.MIN_VALUE;
			for (int i = 0; i < currentSize; i++) {
				float element = (float) array[i];
				if (element > max) {
					max = element;
				}
			}
			return max;
		}

		else if (type.equalsIgnoreCase("long")) {
			long max = Long.MIN_VALUE;
			for (int i = 0; i < currentSize; i++) {
				long element = (long) array[i];
				if (element > max) {
					max = element;
				}
			}
			return max;
		}

		else {
			throw new Exception("The data-type can't be determined");
		}
	}

	@Override
	public synchronized Object[] retainAll(MyCollection mc) {
		int size = 0;
		Object[] tempArr = mc.toArray();
		if (isSorted) {
			for (int i = 0; i < tempArr.length; i++) {
				try {
					int location = binarySearch.search(tempArr[i], currentSize, array, type);
					if (location != -1)
						size++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (size > 0) {
				Object ansArray[] = new Object[size];
				int index = 0;
				for (int i = 0; i < tempArr.length; i++) {
					int location = -1;
					try {
						location = binarySearch.search(tempArr[i], currentSize, array, type);
						if (location != -1) {
							ansArray[index] = tempArr[i];
							index++;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return ansArray;
			}
		} else if (!isSorted) {
			for (int i = 0; i < tempArr.length; i++) {
				for (int j = 0; j < currentSize; j++) {
					if (tempArr[i].equals(array[j])) {
						size++;
					}
				}
			}

			if (size > 0) {
				Object ansArray[] = new Object[size];
				int index = 0;
				for (int i = 0; i < tempArr.length; i++) {
					for (int j = 0; j < currentSize; j++) {
						if (tempArr[i].equals(array[j])) {
							ansArray[index] = array[j];
							index++;
						}
					}
				}
				return ansArray;
			}
		}

		return null;
	}

	@Override
	public synchronized Object[] toArray() {
		Object[] temp = new Object[currentSize];
		for (int i = 0; i < currentSize; i++) {
			temp[i] = array[i];
		}
		return temp;
	}

	@Override
	public synchronized Object get(int index) {
		if (index < currentSize) {
			return array[index];
		} else {
			System.out.println("Error: The provided index isn't valid !");
			return -1;
		}
	}

	@Override
	public synchronized int indexOf(Object o) {
		if (isSorted) {
			try {
				int location = -1;
				location = binarySearch.search(o, currentSize, array, type);
				return location;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			int location = -1;
			location = linearSearch.search(o, currentSize, array);
			return location;
		}
		return -1;
	}

	@Override
	public synchronized int lastIndexOf(Object o) {
		for (int i = currentSize - 1; i >= 0; i--) {
			if (array[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public synchronized void remove(int index) throws Exception {
		// TODO Auto-generated method stub
		if (index >= currentSize || array[index] == null) {
			System.out.println();
			throw new Exception("The specified index isn't a valid index");
		} else if (array[index] != null) {
			int arrIndex = 0;
			Object[] ansArray = new Object[array.length - 1];
			for (int i = 0; i < currentSize; i++) {
				if (i != index && array[i] != null) {
					ansArray[arrIndex] = array[i];
					arrIndex += 1;
				}
			}
			if (isSorted)
				isSorted = true;
			else if (!isSorted) {
				isSorted = false;
			}
			currentSize = arrIndex;
			array = ansArray;
		}
	}

	@Override
	public synchronized void set(int index, Object o) throws Exception {
		// TODO Auto-generated method stub
		if (index >= currentSize) {
			System.out.println();
			throw new Exception("The specified index isn't a valid index");
		} else {
			if (index == 0 || index > 0 && array[index - 1] != null) {
				updateSortingStatusAfterReplacement(index - 1, index, index + 1, array, type);
				array[index] = o;
			} else {
				throw new Exception("Element can't be added at the provided index !");
			}
		}
	}

	@Override
	public synchronized Object[] subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		int size = (toIndex - fromIndex) + 1;
		Object[] tempArr = new Object[size];
		for (int i = 0, j = fromIndex; i < size; i++, j++) {
			tempArr[i] = array[j];
		}
		return tempArr;
	}
}
