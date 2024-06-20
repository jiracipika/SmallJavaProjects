/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Final Exam: Question 10
Any and all work in this file is my own.
*/ 

import java.util.NoSuchElementException;

public class QueueGeneric {

    static class Queue<T> {
        private static class Node<T> {
            private T data;
            private Node<T> next;

            public Node(T data) {
                this.data = data;
            }
        }

        private Node<T> head;
        private Node<T> tail;

        public boolean isEmpty() {
            return head == null;
        }

        public void enqueue(T item) {
            Node<T> node = new Node<>(item);
            if (tail != null) {
                tail.next = node;
            }
            tail = node;
            if (head == null) {
                head = node;
            }
        }

        public T dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            T data = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return data;
        }
    }

    public static void main(String[] args) {
        testIntegerQueue();
        testStringQueue();
    }

    private static void testIntegerQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        boolean isEmptyBefore = queue.isEmpty();
        int dequeued = queue.dequeue();
        boolean isEmptyAfter = queue.isEmpty();

        System.out.println("Integer Queue Test:");
        System.out.println("isEmptyBefore = " + isEmptyBefore);
        System.out.println("dequeued = " + dequeued);
        System.out.println("isEmptyAfter = " + isEmptyAfter);
        System.out.println();
    }

    private static void testStringQueue() {
        Queue<String> queue = new Queue<>();
        boolean isEmptyInitial = queue.isEmpty();
        queue.enqueue("hello");
        queue.enqueue("world");
        queue.dequeue();
        String dequeued = queue.dequeue();
        boolean isEmptyFinal = queue.isEmpty();

        System.out.println("String Queue Test:");
        System.out.println("isEmptyInitial = " + isEmptyInitial);
        System.out.println("dequeued = " + dequeued);
        System.out.println("isEmptyFinal = " + isEmptyFinal);
        System.out.println();
    }
}
