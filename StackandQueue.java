/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Final Exam: Question 13
Any and all work in this file is my own.
*/ 

import java.util.ArrayList;

class Stack<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void push(T element) {
        list.add(element);
    }

    public T pop() {
        if (!isEmpty()) {
            return list.remove(list.size() - 1);
        }
        return null;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

class Queue<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public void enqueue(T element) {
        Node<T> node = new Node<>(element);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
    }

    public T dequeue() {
        if (head != null) {
            T data = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return data;
        }
        return null;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

public class StackandQueue {
    public static void main(String[] args) {
        // Stack Test
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(10);
        int topElement = stack.pop();
        System.out.println(stack.isEmpty());
        System.out.println(topElement);

        // Queue Test
        Queue<String> queue = new Queue<>();
        queue.enqueue("apple");
        queue.enqueue("banana");
        String frontElement = queue.dequeue();
        System.out.println(queue.isEmpty());
        System.out.println(frontElement);
    }
}
