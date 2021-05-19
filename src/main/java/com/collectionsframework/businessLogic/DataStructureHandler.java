package com.collectionsframework.businessLogic;

import com.collectionsframework.rootInterfaces.childInterfaces.concreteImpl.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class DataStructureHandler {

    private String type = "arraylist";
    private ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

    private MyArrayList arrayList = (MyArrayList) context.getBean("arraylist");
    private MyLinkedList linkedList = (MyLinkedList) context.getBean("linkedlist");;
    private MyVector vector = (MyVector) context.getBean("vector");
    private MyStack stack = (MyStack) context.getBean("stack");
    private MyNormalQueue queue = (MyNormalQueue) context.getBean("queue");
    private MyCircularQueue circularQueue = (MyCircularQueue) context.getBean("circularQueue");
    private MyPriorityQueue priorityQueue = (MyPriorityQueue) context.getBean("priorityQueue");
    private MyConcreteSet set = (MyConcreteSet) context.getBean("set");

    /**
     * method to set the current selected Data Structure type
     * @param type the type of the data structure in String format
     */
    public void verifyDataStructure(String type){
        this.type = type;
    }

    /**
     * method to get the current data structure
     * @return  Object[] type array of the current data structure
     */
    public Object[] getCurrentDataStructure(){
        if(type.equals("arraylist")){
            return arrayList.toArray();
        }

        else if(type.equals("vector")){
            return vector.toArray();
        }

        else if(type.equals("linkedlist")){
            return linkedList.toArray();
        }

        else if(type.equals("stack")){
            return stack.toArray();
        }

        else if(type.equals("set")){
            return set.toArray();
        }

        else if(type.equals("queue")){
            return queue.toArray();
        }

        else if(type.equals("circularQueue")){
            return circularQueue.toArray();
        }

        else if(type.equals("priorityQueue")){
            return priorityQueue.toArray();
        }

        else {
            return null;
        }
    }


    /**
     * method to add Object type element into the current selected data structure
     * @param element to add into the data structure
     */
    public void addElement(Object element){
        if(type.equals("arraylist")){
            arrayList.add(element);
        }

        else if(type.equals("vector")){
            vector.add(element);
        }

        else if(type.equals("linkedlist")){
            linkedList.add(element);
        }

        else if(type.equals("stack")){
            stack.add(element);
        }

        else if(type.equals("set")){
            set.add(element);
        }

        else if(type.equals("queue")){
            queue.add(element);
        }

        else if(type.equals("circularQueue")){
            circularQueue.add(element);
        }

        else {
            priorityQueue.add(element);
        }
    }


    /**
     * method to remove Object type element from the current selected data structure
     * @param element to remove from the data structure
     */
    public String removeElement(Object element){
        try{
            if(type.equals("arraylist")){
                arrayList.remove(element);
                return "";
            }

            else if(type.equals("vector")){
                vector.remove(element);
                return "";
            }

            else if(type.equals("linkedlist")){
                linkedList.remove(element);
                return "";
            }

            else if(type.equals("stack")){
                if(stack.peek().equals(element)){
                    stack.pop();
                    return "";
                }
                else{
                    return "The stack can only remove the top most element from it !";
                }
            }

            else if(type.equals("set")){
                set.remove(element);
                return "";
            }

            else if(type.equals("queue")){
                queue.remove(element);
                return "";
            }

            else if(type.equals("circularQueue")){
                circularQueue.remove(element);
                return "";
            }

            else {
                priorityQueue.remove(element);
                return "";
            }
        }catch (Exception e){
            return e.getMessage();
        }
    }


    /**
     * method to get the current data structure size
     * @return int type value as the size of the data structure
     */
    public int getSize(){
        if(type.equals("arraylist")){
            return arrayList.size();
        }

        else if(type.equals("vector")){
            return vector.size();
        }

        else if(type.equals("linkedlist")){
            return linkedList.size();
        }

        else if(type.equals("stack")){
            return stack.size();
        }

        else if(type.equals("set")){
            return set.size();
        }

        else if(type.equals("queue")){
            return queue.size();
        }

        else if(type.equals("circularQueue")){
            return circularQueue.size();
        }

        else {
            return priorityQueue.size();
        }
    }


    /**
     * method to check whether an element present into a data structure or not
     * @param element to be searched
     * @return true if element if found otherwise false
     */
    public boolean searchElement(Object element){
        if(type.equals("arraylist")){
            return arrayList.contains(element);
        }

        else if(type.equals("vector")){
            return vector.contains(element);
        }

        else if(type.equals("linkedlist")){
            return linkedList.contains(element);
        }

        else if(type.equals("stack")){
            return stack.contains(element);
        }

        else if(type.equals("set")){
            return set.contains(element);
        }

        else if(type.equals("queue")){
            return queue.contains(element);
        }

        else if(type.equals("circularQueue")){
            return circularQueue.contains(element);
        }

        else {
            return priorityQueue.contains(element);
        }
    }


    /**
     * method to get the maximum element from the current selected data structure
     * @return Object type max element
     */
    public Object getMaxElement(){
        try{
            if(type.equals("arraylist")){
                return arrayList.max();
            }

            else if(type.equals("vector")){
                return vector.max();
            }

            else if(type.equals("linkedlist")){
                return linkedList.max();
            }

            else if(type.equals("stack")){
                return stack.max();
            }

            else if(type.equals("set")){
                return set.max();
            }

            else if(type.equals("queue")){
                return queue.max();
            }

            else if(type.equals("circularQueue")){
                return circularQueue.max();
            }

            else {
                return priorityQueue.max();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return -1;
    }


    /**
     * method to sort the current selected data structure only if the
     * sorting operation is available for the data structure
     */
    public String sortDataStructure(){
        try{
            if(type.equals("arraylist")){
                arrayList.sort();
                return "";
            }

            else if(type.equals("vector")){
                vector.sort();
                return "";
            }

            else if(type.equals("stack")){
                stack.sort();
                return "";
            }

            else if(type.equals("set")){
                set.sort();
                return "";
            }
            else{
                return "No valid data-structure found to sort !";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
