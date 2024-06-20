/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Assignment 2, Question 2
Any and all work in this file is my own.
*/ 

public class DynamicList<T> {
    private Object[] array;
    private int size;

    public DynamicList() {
        array = new Object[2]; 
        size = 0;
    }

    public void add(T element) {
        if (size == array.length) {
            resize();
        }
        array[size++] = element;
    }

    public void remove(T element) {
        int index = indexOf(element);
        if (index != -1) {
            removeAt(index);
        }
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) array[index]; 
    }

    public int size() {
        return size;
    }

    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    private int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    private void removeAt(int index) {
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        array[size] = null; 
    }

}