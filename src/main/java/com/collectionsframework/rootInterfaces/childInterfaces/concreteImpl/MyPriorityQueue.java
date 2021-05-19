package com.collectionsframework.rootInterfaces.childInterfaces.concreteImpl;

import com.collectionsframework.rootInterfaces.MyCollection;
import com.collectionsframework.rootInterfaces.childInterfaces.MyQueue;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "singleton")
public class MyPriorityQueue implements MyQueue {
	private int front = -1, rear = -1;
	private int maxIndex = -1;
	private int priorityOrder = 0;
	private Object[] queue;
	private String type = null;

	public MyPriorityQueue(String type) {
		this.type = type;
		if (type.equals("int") || type.equals("Integer")) {
			queue = new Integer[1];
		} else if (type.equals("string") || type.equals("String")) {
			queue = new String[1];
		} else if (type.equals("char") || type.equals("Character")) {
			queue = new Character[1];
		} else if (type.equalsIgnoreCase("double")) {
			queue = new Double[1];
		} else if (type.equalsIgnoreCase("float")) {
			queue = new Float[1];
		} else if (type.equalsIgnoreCase("long")) {
			queue = new Long[1];
		} else {
			queue = new Object[1];
		}
	}

	public void print() {
		if (front == -1 && rear == -1) {
			System.out.println("Queue has no elements to print !");
		} else {
			System.out.print("[");
			for (int i = front; i <= rear; i++) {
				if (i < rear) {
					System.out.print(queue[i] + ",");
				} else if (i == rear) {
					System.out.print(queue[i] + "]");
				}
			}
			System.out.println();
		}
	}

	/**
	 * method to increase size by 1 of the array and return it
	 * 
	 * @param queue - the array who's size need to be extended
	 * @return Object[] array with no elements in it
	 */
	private Object[] increaseSize(Object[] queue) {
		if (type.equals("int") || type.equals("Integer")) {
			queue = new Integer[queue.length * 2];
		} else if (type.equals("string") || type.equals("String")) {
			queue = new String[queue.length * 2];
		} else if (type.equals("char") || type.equals("Character")) {
			queue = new Character[queue.length * 2];
		} else if (type.equalsIgnoreCase("double")) {
			queue = new Double[queue.length * 2];
		} else if (type.equalsIgnoreCase("float")) {
			queue = new Float[queue.length * 2];
		} else if (type.equalsIgnoreCase("long")) {
			queue = new Long[queue.length * 2];
		} else {
			queue = new Object[queue.length * 2];
		}
		return queue;
	}

	/**
	 * method to save current queue elements into a temporary queue
	 * 
	 * @param queue the original which elements need to be saved
	 * @return Object[] queue
	 */
	private Object[] saveQueueELements(Object[] queue) {
		int size = rear - front + 1;
		Object[] temp = new Object[size];
		int index = 0;
		for (int i = front; i <= rear; i++) {
			temp[index] = queue[i];
			index++;
		}
		return temp;
	}

	/**
	 * method to copy old array elements into the array with the lastest element as
	 * well
	 * 
	 * @param tempQueue - the old array elements
	 * @param queue   - the current empty array
	 * @param o       - the object type data element to be inserted into the array
	 * @return returns Object[] array
	 */
	private Object[] copyOldQueueElementsWithNewElement(Object[] tempQueue, Object[] queue, Object o) {
		rear = -1;
		front = -1;
		for (int i = 0; i < tempQueue.length; i++) {
			if (rear == -1 && front == -1) {
				front = front + 1;
			}
			rear = rear + 1;
			queue[rear] = tempQueue[i];
		}
		rear = rear + 1;
		queue[rear] = o;
		return queue;
	}

	/**
	 * method to find the maximum int value from the array
	 * 
	 * @param array - the integer array
	 * @return the maximum int value
	 */
	private Object getMax(int array[]) {
		if (front == -1 && rear == -1) {
			return -1;
		}
		int max = array[0];
		for (int i = 0; i <= rear - front; i++) {
			if (array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
		}
		return max;
	}

	/**
	 * method to find the maximum character value from the array
	 * 
	 * @param array - the character array
	 * @return the maximum character value
	 */
	private Object getMax(Character array[]) {
		if (front == -1 && rear == -1) {
			return -1;
		}
		char max = array[0];
		for (int i = 0; i <= rear - front; i++) {
			if (Character.getNumericValue(array[i]) > Character.getNumericValue(max)) {
				max = array[i];
				maxIndex = i;
			}
		}
		return max;
	}

	/**
	 * method to find the maximum string value lexicographically from the array
	 * 
	 * @param array - the string array
	 * @return the maximum string value
	 */
	private Object getMax(String array[]) {
		if (front == -1 && rear == -1) {
			return null;
		}
		String max = array[0];
		for (int i = 0; i <= rear - front; i++) {
			if (max.compareTo(array[i]) < 0) {
				max = array[i];
				maxIndex = i;
			}
		}
		return max;
	}

	/**
	 * method to find the maximum long value from the array
	 * 
	 * @param array - the long array
	 * @return the maximum long value
	 */
	private Object getMax(Long array[]) {
		if (front == -1 && rear == -1) {
			return -1;
		}
		long max = array[0];
		for (int i = 0; i <= rear - front; i++) {
			if (array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
		}
		return max;
	}

	/**
	 * method to find the maximum double value from the array
	 * 
	 * @param array - the double array
	 * @return the maximum double value
	 */
	private Object getMax(Double array[]) {
		if (front == -1 && rear == -1) {
			return -1;
		}
		double max = array[0];
		for (int i = 0; i <= rear - front; i++) {
			if (array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
		}
		return max;
	}

	/**
	 * method to find the maximum float value from the array
	 * 
	 * @param array - the float array
	 * @return the maximum float value
	 */
	private Object getMax(Float array[]) {
		if (front == -1 && rear == -1) {
			return -1;
		}
		float max = array[0];
		for (int i = 0; i <= rear - front; i++) {
			if (array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
		}
		return max;
	}

	@Override
	public Object peek() throws Exception {
		if (maxIndex == -1) {
			throw new Exception("Queue has no elements int it !");
		}
		return queue[maxIndex];
	}

	@Override
	public Object poll() throws Exception {
		// if the queue is empty
		if (front == -1 || front > rear) {
			throw new Exception("Queue has no elements to remove !");
		} else {
			Object element = queue[maxIndex];
			remove(queue[maxIndex]);
			return element;
		}
	}

	@Override
	public int size() {
		return (rear - front) + 1;
	}

	@Override
	public void add(Object o) {
		// if the queue has some space left
		if (rear < queue.length - 1) {
			if (front == -1 && rear == -1) {
				front = front + 1;
			}
			rear = rear + 1;
			queue[rear] = o;
			// if queue has no elements
			if (maxIndex == -1) {
				maxIndex = rear;
			}
			// new element is inserted with existing elements
			else if (maxIndex != -1) {
				if (type.equals("int") || type.equals("Integer")) {
					if ((int) queue[rear] > (int) queue[maxIndex]) {
						maxIndex = rear;
					}
				}

				else if (type.equalsIgnoreCase("string")) {
					if (queue[rear].toString().compareTo(queue[maxIndex].toString()) < 0) {
						maxIndex = rear;
					}
				}

				else if (type.equals("char") || type.equals("Character")) {
					if (Character.getNumericValue((char) queue[rear]) > Character
							.getNumericValue((char) queue[maxIndex])) {
						maxIndex = rear;
					}
				}

				else if (type.equalsIgnoreCase("long")) {
					if ((long) queue[rear] > (long) queue[maxIndex]) {
						maxIndex = rear;
					}
				}

				else if (type.equalsIgnoreCase("float")) {
					if ((float) queue[rear] > (float) queue[maxIndex]) {
						maxIndex = rear;
					}
				}

				else if (type.equalsIgnoreCase("double")) {
					if ((double) queue[rear] > (double) queue[maxIndex]) {
						maxIndex = rear;
					}
				}
			}
		} else {
			Object[] tempQueue = saveQueueELements(queue);
			queue = increaseSize(queue);
			queue = copyOldQueueElementsWithNewElement(tempQueue, queue, o);
			try {
				max();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void remove(Object o) throws Exception {
		if (!queue[maxIndex].equals(o)) {
			throw new Exception("Only the element having the highest priority can be removed from the queue !");
		} else {
			// Theta(1) solution
			if (maxIndex == front) {
				front++;
			}
			// Theta(n) solution
			else {
				Object[] tempQueue = new Object[rear - front + 1];
				int index = 0;
				for (int i = front; i <= rear; i++) {
					if (i != maxIndex) {
						tempQueue[index] = queue[i];
						index++;
					}
				}
				rear = index - 1; // resetting the rear value
				queue = tempQueue;
				max(); // resetting the max element after alteration in queue
			}
		}
	}

	@Override
	public void removeAll(MyCollection mc) {
		Object[] tempArr = mc.toArray();
		for (int i = 0; i < tempArr.length; i++) {
			if (tempArr[i].equals(queue[maxIndex])) {
				try {
					remove(tempArr[i]);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public boolean isEmpty() {
		if (front == -1 && rear == -1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(Object o) {
		for (int i = front; i <= rear; i++) {
			if (queue[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(MyCollection mc) {
		if (front == -1 && rear == -1) {
			return false;
		} else {
			Object[] arr = mc.toArray();
			for (Object element1 : arr) {
				boolean found = false;
				for (int i = front; i <= rear; i++) {
					if (element1.equals(queue[i])) {
						found = true;
						break;
					}
				}
				if (!found) {
					return false;
				}
			}
			return true;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		rear = -1;
		front = -1;
		maxIndex = -1;
	}

	@Override
	public Object max() throws Exception {
		if (type.equals("int") || type.equals("Integer")) {
			int tempArr[] = new int[queue.length];
			int index = 0;
			for (int i = front; i <= rear; i++) {
				tempArr[index] = (int) queue[i];
				index++;
			}
			getMax(tempArr);
			return queue[maxIndex];
		}

		else if (type.equals("string") || type.equals("String")) {
			String tempArr[] = new String[queue.length];
			int index = 0;
			for (int i = front; i <= rear; i++) {
				tempArr[index] = queue[i].toString();
				index++;
			}
			getMax(tempArr);
			return queue[maxIndex];
		}

		else if (type.equals("char") || type.equals("Character")) {
			Character tempArr[] = new Character[queue.length];
			int index = 0;
			for (int i = front; i <= rear; i++) {
				tempArr[index] = (char) queue[i];
				index++;
			}
			getMax(tempArr);
			return queue[maxIndex];
		}

		else if (type.equalsIgnoreCase("double")) {
			Double tempArr[] = new Double[queue.length];
			int index = 0;
			for (int i = front; i <= rear; i++) {
				tempArr[index] = (double) queue[i];
				index++;
			}
			getMax(tempArr);
			return queue[maxIndex];
		}

		else if (type.equalsIgnoreCase("float")) {
			Float tempArr[] = new Float[queue.length];
			int index = 0;
			for (int i = front; i <= rear; i++) {
				tempArr[index] = (float) queue[i];
				index++;
			}
			getMax(tempArr);
			return queue[maxIndex];
		}

		else if (type.equalsIgnoreCase("long")) {
			Long tempArr[] = new Long[queue.length];
			int index = 0;
			for (int i = front; i <= rear; i++) {
				tempArr[index] = (long) queue[i];
				index++;
			}
			getMax(tempArr);
			return queue[maxIndex];
		}

		else {
			throw new Exception("The data-type can't be determined");
		}
	}

	@Override
	public Object[] retainAll(MyCollection mc) {
		int size = 0;
		Object[] tempArr = mc.toArray();
		for (int i = 0; i < tempArr.length; i++) {
			for (int j = front; j <= rear; j++) {
				if (tempArr[i].equals(queue[j])) {
					size++;
				}
			}
		}

		if (size > 0) {
			Object ansArray[] = new Object[size];
			int index = 0;
			for (int i = 0; i < tempArr.length; i++) {
				for (int j = front; j <= rear; j++) {
					if (tempArr[i].equals(queue[j])) {
						ansArray[index] = queue[j];
						index++;
					}
				}
			}
			return ansArray;
		}

		return null;
	}

	@Override
	public Object[] toArray() {
		if (rear > -1 && front > -1) {
			Object arr[] = new Object[rear - front + 1];
			for (int i = front; i <= rear; i++) {
				arr[i] = queue[i];
			}
			return arr;
		}
		return null;
	}

}
