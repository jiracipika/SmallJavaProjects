/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Lab 8
Any and all work in this file is my own.
*/ 

public class BasedArrayStack {
    private char[] stackArray;
    private int top;

    public BasedArrayStack(int size) throws StackException {
        if (size <= 0) {
            throw new StackException("Stack size must be positive");
        }
        stackArray = new char[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(char item) throws StackException {
        if (top == stackArray.length - 1) {
            throw new StackException("Stack overflow");
        }
        stackArray[++top] = item;
    }

    public char pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Stack underflow");
        }
        return stackArray[top--];
    }

    public void popAll() {
        top = -1;
    }

    public char peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("Stack underflow");
        }
        return stackArray[top];
    }
}

class StackException extends Exception {
    public StackException(String message) {
        super(message);
    }
}
