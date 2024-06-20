/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Lab 8
Any and all work in this file is my own.
*/ 

public class QueueTest {
    public static void main(String[] args) {
        Queuelab queue = new Queuelab();

        try {
            String[] names = {"Rajin", "Margaret", "Nicole", "Michelle", "Diana", "Keira", "Tiana", "Zarina", "Hannah", "Ian"};
            for (String name : names) {
                queue.enqueue(name);
                System.out.println("Enqueue: " + name + " | Queue: " + queue);
            }

            while (!queue.isEmpty()) {
                System.out.println("Dequeue: " + queue.dequeue() + " | Queue: " + queue);
            }
        } catch (QueueException e) {
            System.out.println(e.getMessage());
        }
    }
}
