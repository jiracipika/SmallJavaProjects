/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Assignment 2, Question 1
Any and all work in this file is my own.
*/ 

public class ArrayList<E> extends AbstractList<E> {
    private Object[] array; 
    private int capacity;
    private int size;

    public ArrayList() {
        capacity = 10; 
        array = new Object[capacity];
        size = 0;
    }


    public void add(E element) {
        if (size == capacity) {
            increaseCapacity();
        }
        array[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removedElement = (E) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return removedElement;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) array[index];
    }

  
    public int size() {
        return size;
    }

    private void increaseCapacity() {
        capacity = capacity * 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
