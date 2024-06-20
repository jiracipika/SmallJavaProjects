/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Lab 7
Any and all work in this file is my own.
*/ 

public class SingleSortedLinkedList {
    private SingleNode head;

    public SingleSortedLinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        SingleNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void insert(String item) throws LinkedListException {
        SingleNode newNode = new SingleNode(item);
        if (head == null || head.item.compareTo(item) >= 0) {
            newNode.next = head;
            head = newNode;
        } else {
            SingleNode current = head;
            while (current.next != null && current.next.item.compareTo(item) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public String remove(int i) throws LinkedListException {
        if (isEmpty() || i < 0 || i >= size()) {
            throw new LinkedListException("Invalid index for remove operation");
        }
        SingleNode removedNode;
        if (i == 0) {
            removedNode = head;
            head = head.next;
        } else {
            SingleNode current = head;
            for (int j = 0; j < i - 1; j++) {
                current = current.next;
            }
            removedNode = current.next;
            current.next = removedNode.next;
        }
        return removedNode.item;
    }

    public void removeAll() {
        head = null;
    }

    public String get(int i) throws LinkedListException {
        if (isEmpty() || i < 0 || i >= size()) {
            throw new LinkedListException("Invalid index for removal operation");
        }
        SingleNode current = head;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        return current.item;
    }

    public int find(String item) {
        SingleNode current = head;
        int index = 0;
        while (current != null) {
            if (current.item.equals(item)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SingleNode current = head;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append(" -> null");
        return sb.toString();
    }
}
