/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Lab 6
Any and all work in this file is my own.
*/ 

public class SingleLinkedList {
    private SingleNode head;

    public SingleLinkedList() {
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

    public void add(String item, int i) throws ListException {
        if (i < 0 || i > size()) {
            throw new ListException("Invalid index for add");
        }
        SingleNode newNode = new SingleNode(item);
        if (i == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            SingleNode current = head;
            for (int j = 0; j < i - 1; j++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public String remove(int i) throws ListException {
        if (isEmpty() || i < 0 || i >= size()) {
            throw new ListException("Invalid index for remove");
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

    public String get(int i) throws ListException {
        if (isEmpty() || i < 0 || i >= size()) {
            throw new ListException("Invalid index for get");
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

    public void addLast(String item) {
    }

    public String removeFirst() {
        return null;
    }

    public String getFirst() {
        return null;
    }
}
