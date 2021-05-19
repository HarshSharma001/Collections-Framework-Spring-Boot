package com.collectionsframework.rootInterfaces.childInterfaces.concreteImpl;

import com.collectionsframework.rootInterfaces.MyCollection;
import com.collectionsframework.rootInterfaces.childInterfaces.MyQueue;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "singleton")
public class MyNormalQueue implements MyQueue {
	private int front = -1, rear = -1;
	private Object[] queue;
	private String type = null;

	public MyNormalQueue(String type) {
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
	 * method to copy old array elements into the array with the lastest element as
	 * well
	 * 
	 * @param tempQueue - the old array elements
	 * @param queue  - the current empty array
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
			}
		}
		return max;
	}

	@Override
	public Object peek() throws Exception {
		if (front == -1) {
			throw new Exception("Queue has no elements int it !");
		}
		return queue[front];
	}

	@Override
	public Object poll() throws Exception {
		// if the queue is empty
		if (front == -1 || front > rear) {
			throw new Exception("Queue has no elements to remove !");
		} else {
			Object element = queue[front];
			queue[front] = null;
			front = front + 1;
			return element;
		}
	}

	@Override
	public int size() {
		if (front == -1 && rear == -1)
			return 0;
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
		} else {
			Object[] tempQueue = saveQueueELements(queue);
			queue = increaseSize(queue);
			queue = copyOldQueueElementsWithNewElement(tempQueue, queue, o);
		}
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void remove(Object o) throws Exception {
		// if the queue is empty
		if (front == -1 || front > rear) {
			throw new Exception("Queue has no elements to remove !");
		} else {
			if (queue[front].equals(o)) {
				queue[front] = null;
				front = front + 1;
			} else {
				System.out.println("Queue can only delete elements from the front end !");
			}
		}
	}

	@Override
	public void removeAll(MyCollection mc) {
		System.out.println("Method isn't available, because of considering the fact of Queue's principle !");
	}

	@Override
	public boolean isEmpty() {
		if (front == -1 && rear == -1)
			return true;
		else
			return false;
	}

	@Override
	public boolean contains(Object o) {
		if (front == -1 && rear == -1) {
			return false;
		} else {
			for (int i = front; i <= rear; i++) {
				if (queue[i].equals(o)) {
					return true;
				}
			}
			return false;
		}
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
		front = -1;
		rear = -1;
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
			return getMax(tempArr);
		}

		else if (type.equals("string") || type.equals("String")) {
			String tempArr[] = new String[queue.length];
			int index = 0;
			for (int i = front; i <= rear; i++) {
				tempArr[index] = queue[i].toString();
				index++;
			}
			return getMax(tempArr);
		}

		else if (type.equals("char") || type.equals("Character")) {
			Character tempArr[] = new Character[queue.length];
			int index = 0;
			for (int i = front; i <= rear; i++) {
				tempArr[index] = (char) queue[i];
				index++;
			}
			return getMax(tempArr);
		}

		else if (type.equalsIgnoreCase("double")) {
			Double tempArr[] = new Double[queue.length];
			int index = 0;
			for (int i = front; i <= rear; i++) {
				tempArr[index] = (double) queue[i];
				index++;
			}
			return getMax(tempArr);
		}

		else if (type.equalsIgnoreCase("float")) {
			Float tempArr[] = new Float[queue.length];
			int index = 0;
			for (int i = front; i <= rear; i++) {
				tempArr[index] = (float) queue[i];
				index++;
			}
			return getMax(tempArr);
		}

		else if (type.equalsIgnoreCase("long")) {
			Long tempArr[] = new Long[queue.length];
			int index = 0;
			for (int i = front; i <= rear; i++) {
				tempArr[index] = (long) queue[i];
				index++;
			}
			return getMax(tempArr);
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
