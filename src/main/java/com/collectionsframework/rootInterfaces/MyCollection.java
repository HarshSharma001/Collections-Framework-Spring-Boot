package com.collectionsframework.rootInterfaces;

public interface MyCollection {
    /**
     * method to return size of the collection
     *
     * @param no parameters will be provided
     * @return returns int value as size of the collection
     */
    int size();

    /**
     * method to add new element into the MyCollection
     *
     * @param o - the object type data element
     */
    void add(Object o);

    /**
     * method to get the collection type
     *
     * @return string value representing type of the collection
     */
    String getType();

    /**
     * method to remove the specified element from MyCollection
     *
     * @param o - the Object type element to be removed
     */
    void remove(Object o) throws Exception;

    /**
     * method to remove the specified MyCollection from Parent MyCollection
     *
     * @param o - the sub instance of MyCollection to be removed
     */
    void removeAll(MyCollection mc);

    /**
     * method to check whether the collection is empty or not
     *
     * @param no parameters will be provided
     * @return returns true if the collection is empty else false
     */
    boolean isEmpty();

    /**
     * method to check whether an element is present in the collection or not
     *
     * @param o - an object type data element to be checked from the collection
     * @return returns true if the element is present else false
     */
    boolean contains(Object o);

    /**
     * method to check whether a Parent MyCollection contains a sub MyCollection in
     * it
     *
     * @param mc - a sub MyCollection instance
     * @return retur true if the sub MyCollection is present in the parent
     *         MyCollection else false
     */
    boolean containsAll(MyCollection mc);

    /**
     * method to delete all the elements from the collection
     *
     * @param no parameters required
     */
    void clear();

    /**
     * method to get the maximum value from the MyCollection
     *
     * @return return Object type maximum value from the MyCollection
     */
    Object max() throws Exception;

    /**
     * method to get the sub MyCollection elements only which are present in parent
     * MyCollection
     *
     * @param mc - the instance of sub MyCollection
     * @return
     */
    Object[] retainAll(MyCollection mc);

    /**
     * method to convert the MyCollection into an array
     *
     * @return returns an Object type array
     */
    Object[] toArray();
}
