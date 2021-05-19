package com.collectionsframework.rootInterfaces.childInterfaces.concreteImpl;

import com.collectionsframework.rootInterfaces.MyCollection;
import com.collectionsframework.rootInterfaces.childInterfaces.MyList;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "singleton")
public class MyLinkedList implements MyList {
	private Node head;
	private String type = null;
	private int currentSize = 0;

	public MyLinkedList(String type) {
		this.type = type;
	}

	public void print() {
		if (head == null) {
			System.out.println("No elements present in the linked-list");
		} else {
			Node current = head;
			System.out.println(current);
		}
	}

	public void printArray(Object[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1) {
				System.out.print(arr[i] + ", ");
			} else if (i == arr.length - 1) {
				System.out.print(arr[i]);
			}
		}
		System.out.print("]");
		System.out.println();
	}

	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public void add(Object data) {
		if (head == null) {
			head = new Node(data);
			currentSize++;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(data);
			currentSize++;
		}
	}

	public void append(Object data) {
		if (head == null) {
			head = new Node(data);
			currentSize++;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(data);
			currentSize++;
		}
	}

	public String getType() {
		return this.type;
	}

	@Override
	public void remove(Object data) throws Exception {
		// TODO Auto-generated method stub
		if (head == null) {
			throw new Exception("Linkedlist has no elements to delete !");
		} else {
			if (head.data.equals(data)) {
				head = head.next;
				return;
			}
			Node current = head;
			while (!current.next.data.equals(data)) {
				current = current.next;
			}
			current.next = current.next.next;
			currentSize--;
			return;
		}
	}

	@Override
	public void removeAll(MyCollection mc) {
		// TODO Auto-generated method stub
		if (head == null) {
			System.out.println("Linkedlist has no elements to return !");
			return;
		}
		Object[] array = mc.toArray();
		for (Object data : array) {
			Node current = head;
			while (!current.next.data.equals(data)) {
				current = current.next;
			}
			if (current.data.equals(data)) {
				current.next = current.next.next;
				currentSize--;
			}
		}
	}

	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(Object data) {
		if (head == null) {
			System.out.println("Linkedlist has no elements in it !");
		} else {
			Node current = head;
			while (current.next != null) {
				if (current.data.equals(data)) {
					return true;
				}
				current = current.next;
			}
			if (current.data.equals(data)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(MyCollection mc) {
		if (head == null) {
			System.out.println("LinkedList has no elements in it !");
		}
		Object[] arr = mc.toArray();

		for (Object data : arr) {
			Node current = head;
			boolean matched = false;
			while (current.next != null) {
				if (current.data.equals(data)) {
					matched = true;
					break;
				}
				current = current.next;
			}
			if (!matched && current.data.equals(data)) {
				matched = true;
			}

			if (!matched) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void clear() {
		head = null;
		currentSize = 0;
		return;
	}

	@Override
	public Object max() throws Exception {
		if (head == null) {
			throw new Exception("Linkedlist has no elements to get the maximum value !");
		}

		if (type.equals("int") || type.equals("Integer")) {
			int max = (int) head.data;
			Node current = head;
			while (current.next != null) {
				if ((int) current.data > max) {
					max = (int) current.data;
				}
				current = current.next;
			}
			if ((int) current.data > max) {
				max = (int) current.data;
			}
			return max;
		}

		else if (type.equalsIgnoreCase("string")) {
			String max = head.data.toString();
			Node current = head;
			while (current.next != null) {
				if (max.compareTo(current.data.toString()) < 0) {
					max = current.data.toString();
				}
				current = current.next;
			}
			if (max.toString().compareTo(current.data.toString()) < 0) {
				max = current.data.toString();
			}
			return max;
		}

		else if (type.equalsIgnoreCase("char") || type.equals("Character")) {
			char max = (char) head.data;
			Node current = head;
			while (current.next != null) {
				if (Character.getNumericValue(max) < Character.getNumericValue((char) current.data)) {
					max = (char) current.data;
				}
				current = current.next;
			}
			if (Character.getNumericValue(max) < Character.getNumericValue((char) current.data)) {
				max = (char) current.data;
			}
			return max;
		}

		if (type.equalsIgnoreCase("long")) {
			long max = (long) head.data;
			Node current = head;
			while (current.next != null) {
				if ((long) current.data > max) {
					max = (long) current.data;
				}
				current = current.next;
			}
			if ((long) current.data > (long) max) {
				max = (long) current.data;
			}
			return max;
		}

		if (type.equalsIgnoreCase("float")) {
			float max = (float) head.data;
			Node current = head;
			while (current.next != null) {
				if ((float) current.data > max) {
					max = (float) current.data;
				}
				current = current.next;
			}
			if ((float) current.data > max) {
				max = (float) current.data;
			}
			return max;
		}

		if (type.equalsIgnoreCase("double")) {
			double max = (double) head.data;
			Node current = head;
			while (current.next != null) {
				if ((double) current.data > max) {
					max = (double) current.data;
				}
				current = current.next;
			}
			if ((double) current.data > max) {
				max = (double) current.data;
			}
			return max;
		} else {
			throw new Exception("Linkedlist datatype can't be determined !");
		}
	}

	@Override
	public Object[] retainAll(MyCollection mc) {
		if (head == null) {
			System.out.println("Linkedlist has no elements in it !");
			return null;
		} else {
			Node current = head;
			int size = 0;

			Object[] tempArr = mc.toArray();
			for (Object o : tempArr) {
				boolean alreadyFound = false;
				while (current.next != null) {
					if (o.equals(current.data)) {
						size++;
						alreadyFound = true;
						break;
					}
					current = current.next;
				}
				if (o.equals(current.data) && !alreadyFound) {
					size++;
				}
			}

			current = head;
			Object[] ansArray = new Object[size];
			int index = 0;
			for (Object o : tempArr) {
				while (current.next != null) {
					if (o.equals(current.data)) {
						ansArray[index] = o;
						index++;
						current = current.next;
						break;
					}
					current = current.next;
				}
				if (o.equals(current.data)) {
					ansArray[index] = o;
					index++;
				}
			}
			return ansArray;
		}
	}

	@Override
	public Object[] toArray() {
		if (head == null) {
			return null;
		} else {
			Object[] arr = new Object[currentSize];
			int index = 0;
			Node current = head;
			while (current.next != null) {
				arr[index] = current.data;
				current = current.next;
				index++;
			}
			arr[index] = current.data;
			current = current.next;
			index++;
			return arr;
		}
	}

	@Override
	public Object get(int index) {
		if (head == null) {
			System.out.println("Error : Linkedlist has no element to get !");
			return null;
		} else {
			if (index > currentSize) {
				System.out.println("Error : Invalid index entered !");
				return null;
			}
			Node current = head;
			while (current.next != null && index > 0) {
				index--;
				current = current.next;
			}
			return current.data;
		}
	}

	@Override
	public int indexOf(Object data) {
		if (head == null) {
			return -1;
		} else {
			if (head.data.equals("data")) {
				return 0;
			}
			int index = 1;
			Node current = head;
			while (current.next != null) {
				if (current.data.equals(data)) {
					return index;
				}
				index++;
				current = current.next;
			}
			if (current.data.equals(data)) {
				return index;
			}

			return -1;
		}
	}

	@Override
	public int lastIndexOf(Object data) {
		if (head == null) {
			System.out.println("Error : Linkedlist has no elements to get !");
			return -1;
		} else {
			Node current = head;
			int lastIndex = -1, index = 1;

			if (head.data.equals(data)) {
				lastIndex = 0;
			}

			while (current.next != null) {
				if (current.data.equals(data)) {
					lastIndex = index;
				}
				index++;
				current = current.next;
			}
			if (current.data.equals(data)) {
				lastIndex = index;
			}
			return lastIndex;
		}
	}

	@Override
	public void remove(int index) throws Exception {
		if (head == null || index > currentSize) {
			throw new Exception("The Linkedlist has no elements to remove !");
		} else {
			if (index == currentSize) {
				Node current = head;
				while (current.next != null && index > 1) {
					index--;
					current = current.next;
				}
				current.next = null;
				currentSize--;
				return;
			}

			if (index == 0) {
				head = head.next;
				return;
			}
			Node current = head;
			while (current.next != null && index > 1) {
				index--;
				current = current.next;
			}
			current.next = current.next.next;
			currentSize--;
		}
		return;
	}

	@Override
	public void set(int index, Object data) throws Exception {
		if (head == null && index == 0) {
			head = new Node(data);
			return;
		} else if (head == null) {
			throw new Exception("Linkedlist has no elements in it !");
		}

		else {
			if (index > currentSize) {
				throw new Exception("Index out of bounds exception !");
			}
			Node current = head;
			while (current.next != null && index > 0) {
				index--;
				current = current.next;
			}
			current.data = data;
		}
	}

	@Override
	public Object[] subList(int fromIndex, int toIndex) {
		if (fromIndex < 0 || toIndex > currentSize) {
			return null;
		} else {
			int size = (toIndex - fromIndex) + 1;
			Node current = head;
			int counter = 0, index = 0;
			Object[] arr = new Object[size];

			while (current.next != null && index < size) {
				if (counter >= fromIndex) {
					arr[index] = current.data;
					index++;
				} else if (counter < fromIndex) {
					counter++;
				}
				current = current.next;
			}
			if (index < size) {
				arr[index] = current.data;
			}
			return arr;
		}
	}

}
