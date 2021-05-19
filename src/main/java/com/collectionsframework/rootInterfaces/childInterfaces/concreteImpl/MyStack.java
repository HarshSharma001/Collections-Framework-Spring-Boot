package com.collectionsframework.rootInterfaces.childInterfaces.concreteImpl;

import com.collectionsframework.rootInterfaces.MyCollection;
import com.collectionsframework.searching.LinearSearch;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "singleton")
public class MyStack extends MyVector {
	private int top = -1;
	private Object[] stack;
	private String type = null;
	private LinearSearch linearSearch;

	/**
	 * constructor to initialize the stack with the specified type
	 * 
	 * @param type - the data type of the stack
	 */
	public MyStack(String type) {
		super(type);
		linearSearch = new LinearSearch();
		this.type = type;
		if (type.equals("int") || type.equals("Integer")) {
			stack = new Integer[1];
		} else if (type.equals("string") || type.equals("String")) {
			stack = new String[1];
		} else if (type.equals("char") || type.equals("Character")) {
			stack = new Character[1];
		} else if (type.equalsIgnoreCase("double")) {
			stack = new Double[1];
		} else if (type.equalsIgnoreCase("float")) {
			stack = new Float[1];
		} else if (type.equalsIgnoreCase("long")) {
			stack = new Long[1];
		} else {
			stack = new Object[1];
		}
	}

	/**
	 * method to print provided stack
	 * 
	 * @param argStack - to be printed
	 */
	private void printStack(Object[] argStack) {
		System.out.print("[");
		for (int i = 0; i <= top; i++) {
			if (i < top) {
				System.out.print(argStack[i] + ", ");
			} else {
				System.out.print(argStack[i]);
			}
		}
		System.out.print("]");
		System.out.println();
	}

	/**
	 * method to copy old stack elements into the stack with the lastest element as
	 * well
	 * 
	 * @param tempArr - the old stack elements
	 * @param stack   - the current empty stack
	 * @param o       - the object type data element to be inserted into the stack
	 * @return returns Object[] stack
	 */

	private Object[] copyOldArrayElementsWithNewElement(Object[] tempArr, Object[] stack, Object o) {
		int tempTop = -1;
		for (int i = 0; i <=top; i++) {
			tempTop = tempTop + 1;
			stack[tempTop] = tempArr[i];
		}
		tempTop = tempTop + 1;
		top = tempTop;
		stack[tempTop] = o;

		return stack;
	}

	/**
	 * method to save current stack elements into a temporary stack
	 * 
	 * @param stack - the original stack which elements need to be saved
	 * @return Object[] stack
	 */
	private Object[] saveArrayELements(Object[] stack) {
		Object[] temp = new Object[stack.length];
		int tempTop = -1;
		for (int i = 0; i<=top; i++) {
			tempTop = tempTop + 1;
			temp[tempTop] = stack[i];
		}
		return temp;
	}

	/**
	 * method to increase size by 1 of the stack and return it
	 * 
	 * @param stack - the stack who's size need to be extended
	 * @return Object[] stack with no elements in it
	 */
	private Object[] increaseSize(Object[] stack) {
		if (type.equals("int") || type.equals("Integer")) {
			stack = new Integer[stack.length * 2];
		} else if (type.equals("string") || type.equals("String")) {
			stack = new String[stack.length * 2];
		} else if (type.equals("char") || type.equals("Character")) {
			stack = new Character[stack.length * 2];
		} else if (type.equalsIgnoreCase("double")) {
			stack = new Double[stack.length * 2];
		} else if (type.equalsIgnoreCase("float")) {
			stack = new Float[stack.length * 2];
		} else if (type.equalsIgnoreCase("long")) {
			stack = new Long[stack.length * 2];
		} else {
			stack = new Object[stack.length * 2];
		}
		return stack;
	}

	/**
	 * public method to print the dynamic stack from outside
	 */
	public void print() {
		printStack(stack);
	}

	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * method to return the current size of the stack
	 * 
	 * @return returns positive int value
	 */
	@Override
	public int size() {
		if (top == -1) {
			return 0;
		} else {
			return top + 1;
		}
	}

	/**
	 * method to add elements into the stack
	 * 
	 * @param o - the object type data element to be inserted into the stack
	 */
	public void push(Object o) {
		if (top < stack.length - 1) {
			top = top + 1;
			stack[top] = o; // In constant time
		} else {
			Object[] tempArr = saveArrayELements(stack);
			stack = increaseSize(stack);
			stack = copyOldArrayElementsWithNewElement(tempArr, stack, o);
		}
	}

	/**
	 * method to get the element available at the top of the stack
	 * 
	 * @return An Object type element if available at the stack-top
	 * @throws Exception - Stack has no elements to return
	 */
	public Object peek() throws Exception {
		if (top > -1 && top < stack.length - 1 && stack[top] != null) {
			return stack[top];
		} else {
			throw new Exception("The provided Stack top has no elements to display !");
		}
	}

	/**
	 * method to add elements into the stack
	 * 
	 * @param o - the object type data element to be inserted into the stack
	 */
	@Override
	public void add(Object o) {
		if (top < stack.length - 1) {
			top = top + 1;
			stack[top] = o; // In constant time
		} else {
			Object[] tempArr = saveArrayELements(stack);
			stack = increaseSize(stack);
			stack = copyOldArrayElementsWithNewElement(tempArr, stack, o);
		}
	}

	/**
	 * method to remove and return the current stack-top element
	 * 
	 * @return the current stack-top element which is popped now
	 * @throws Exception Stack has no elements to pop
	 */
	public Object pop() throws Exception {
		if (top == -1) {
			System.out.println();
			throw new Exception("The stack has no elements to pop !");
		} else {
			Object poppedElement = stack[top];
			stack[top] = null;
			top--; // In constant time
			return poppedElement;
		}
	}

	/**
	 * method to check whether stack has any elements available in it or not
	 * 
	 * @return true if stack has even a single element else false
	 */
	@Override
	public boolean isEmpty() {
		if (top == -1)
			return true;
		else
			return false;
	}

	/**
	 * method to check whether a particular element is present in the stack or not
	 * 
	 * @return true if stack has the particular element else false
	 */
	@Override
	public boolean contains(Object element) {
		if (linearSearch.search(element, top+1, stack) == -1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * method to check whether a particular set of elements are present in the stack
	 * or not
	 * 
	 * @return true if stack has the particular set of elements else false
	 */
	@Override
	public boolean containsAll(MyCollection mc) {
		// TODO Auto-generated method stub
		if (!mc.getType().equalsIgnoreCase(this.type)) {
			System.out.println("Error : type mismatch of the provided collections !");
			return false;
		}
		
		Object[] tempArr = mc.toArray();
		for (Object o : tempArr) {
			if (linearSearch.search(o, top+1, stack) == -1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * method to delete all elements from the stack
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		top = -1;
		if (type.equals("int") || type.equals("Integer")) {
			stack = new Integer[1];
		} else if (type.equals("string") || type.equals("String")) {
			stack = new String[1];
		} else if (type.equals("char") || type.equals("Character")) {
			stack = new Character[1];
		} else if (type.equalsIgnoreCase("double")) {
			stack = new Double[1];
		} else if (type.equalsIgnoreCase("float")) {
			stack = new Float[1];
		} else if (type.equalsIgnoreCase("long")) {
			stack = new Long[1];
		} else {
			stack = new Object[1];
		}
	}

	/**
	 * method to return the maximum element from the stack
	 * 
	 * @return the maximum available element from the stack
	 * @exception "stack" has no elements/stack datatype is not defined
	 */
	@Override
	public Object max() throws Exception {
		// TODO Auto-generated method stub
		if (top == -1) {
			throw new Exception("The stack has no elements i.e. stack is empty !");
		}

		if (type.equals("int") || type.equals("Integer")) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < top+1; i++) {
				int element = (int) stack[i];
				if (element > max) {
					max = element;
				}
			}
			return max;
		}

		else if (type.equals("string") || type.equals("String")) {
			String max = "";
			for (int i = 0; i < top+1; i++) {
				String element = stack[i].toString();
				if (max.compareTo(element) < 0) {
					max = element;
				}
			}
			return max;
		}

		else if (type.equals("char") || type.equals("Character")) {
			char max = (char) stack[0];
			for (int i = 1; i < top+1; i++) {
				char c = (char) stack[i];
				if (Character.getNumericValue(c) > Character.getNumericValue(max)) {
					max = c;
				}
			}
			return max;
		}

		else if (type.equalsIgnoreCase("double")) {
			double max = Double.MIN_VALUE;
			for (int i = 0; i < top+1; i++) {
				double element = (double) stack[i];
				if (element > max) {
					max = element;
				}
			}
			return max;
		}

		else if (type.equalsIgnoreCase("float")) {
			float max = Float.MIN_VALUE;
			for (int i = 0; i < top+1; i++) {
				float element = (float) stack[i];
				if (element > max) {
					max = element;
				}
			}
			return max;
		}

		else if (type.equalsIgnoreCase("long")) {
			long max = Long.MIN_VALUE;
			for (int i = 0; i < top+1; i++) {
				long element = (long) stack[i];
				if (element > max) {
					max = element;
				}
			}
			return max;
		}

		else {
			throw new Exception("The stack data-type can't be determined");
		}
	}

	/**
	 * method to get the sub MyCollection elements only which are present in the
	 * stack
	 * 
	 * @param mc - the instance of sub MyCollection
	 * @return
	 */
	@Override
	public Object[] retainAll(MyCollection mc) {
		// TODO Auto-generated method stub
		Object[] tempArr = mc.toArray();
		Object[] ansArr = new Object[tempArr.length];
		int index = 0;
		for (Object obj : tempArr) {
			if (linearSearch.search(obj, top+1, stack) != -1) {
				ansArr[index] = obj;
				index++;
			}
		}

		Object[] temp = new Object[index];
		for (int j = 0; j < index; j++) {
			temp[j] = ansArr[j];
		}

		return temp;
	}

	/**
	 * method to get stack into an array form
	 * 
	 * @return Object[] type array
	 */
	@Override
	public Object[] toArray() {
		Object[] temp = new Object[top + 1];
		for (int i = 0; i <= top; i++) {
			temp[i] = stack[i];
		}
		return temp;
	}

	/**
	 * method to get Object type element available at the stack-index
	 * 
	 * @param index - the element at stack[index]
	 * @return the Object type element
	 */
	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		if (index != top) {
			System.out.println("Error : You can only access the top element of the Stack !");
			return -1;
		} else {
			return stack[index];
		}
	}

	/**
	 * method to get the index of a particular element from the stack
	 * 
	 * @param o - the Object type element
	 */
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= top; i++) {
			if (stack[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * method to get the last index of a particular element from the stack
	 * 
	 * @param o - the Object type element
	 */
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		for (int i = top; i > -1; i--) {
			if (stack[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * method to pop a particular element from the stack with a given index
	 * 
	 * @param index - the index of which element needs to be removed
	 */
	@Override
	public void remove(int index) throws Exception {
		// TODO Auto-generated method stub
		if (index != top) {
			System.out.println();
			throw new Exception("Elements can only be removed from the top of the stack !");
		} else {
			stack[top] = null;
			top--; // In constant time
		}
	}

	/**
	 * method to set/replaces specified element at specified index in stack
	 * 
	 * @param index the integer index
	 * @param o     - the element to set
	 */
	@Override
	public void set(int index, Object o) throws Exception {
		// TODO Auto-generated method stub
		if (index != top && top < stack.length - 1) {
			System.out.println();
			throw new Exception("Elements can only be replaced at the top of the Stack !");
		} else {
			stack[top] = o;
		}
	}

	/**
	 * method to get a sub stack with specified indexes from the parent stack
	 * 
	 * @param fromIndex - the starting index including
	 * @param toIndex   - the ending index including
	 * @return returns Object[] instance
	 */
	@Override
	public Object[] subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		if (fromIndex < -1 || toIndex < -1 || fromIndex > top || toIndex > top) {
			return new Object[0];
		} else {
			int size = (toIndex - fromIndex) + 1;

			Object[] tempArr = new Object[size];
			for (int i = 0, j = fromIndex; i < size; i++, j++) {
				tempArr[i] = stack[j];
			}
			return tempArr;
		}
	}

}
