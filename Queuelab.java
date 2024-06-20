/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Lab 8
Any and all work in this file is my own.
*/ 

public class Queuelab {
    private SingleLinkedList list;

    public Queuelab() {
        this.list = new SingleLinkedList();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void enqueue(String item) {
        list.addLast(item);
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new QueueException("Queue is empty. Cannot dequeue.");
        }
        return list.removeFirst();
    }

    public void dequeueAll() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    public String peek() {
        if (isEmpty()) {
            throw new QueueException("Queue is empty. Cannot peek.");
        }
        return list.getFirst();
    }

    public int size() {
        return list.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            try {
                sb.append(list.get(i));
            } catch (ListException e) {
                e.printStackTrace();
            }
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
