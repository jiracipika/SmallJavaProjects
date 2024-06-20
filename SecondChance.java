import java.util.Random;

public class SecondChance {
    
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class CircularLinkedList {
        Node head = null;
        Node tail = null;
        int size = 0;

        public void append(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            tail.next = head;
            size++;
        }

        public void setRandomValues() {
            Random rand = new Random();
            Node current = head;
            for (int i = 0; i < size; i++) {
                current.data = rand.nextInt(2); // Randomly sets to 0 or 1
                current = current.next;
            }
        }

        public void printList() {
            Node current = head;
            for (int i = 0; i < size; i++) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        public int findVictim(int startIndex) {
            Node current = head;
            for (int i = 0; i < startIndex; i++) {
                current = current.next;
            }
            int index = startIndex;
            do {
                if (current.data == 0) {
                    current.data = 1; //Fill free page
                    return index; //Return victim's index
                }
                current.data = 0; //Give a second chance
                current = current.next; 
                index = (index + 1) % size; //Keep index within list size
            } while (index != startIndex); //Loop until we come back around

            return -1; //If all pages are given second chance
        }
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        int sizeOfList = new Random().nextInt(11) + 20; // Size between 20 and 30
        for (int i = 0; i < sizeOfList; i++) {
            cll.append(0);
        }

        cll.setRandomValues();
        System.out.println("Initial circular linked list:");
        cll.printList();

        int[] victims = new int[3]; 
        //prompt user for input 

        for (int i = 0; i < victims.length; i++) {
            // Simulating user input for demonstration purposes
            victims[i] = new Random().nextInt(sizeOfList);
            System.out.println("User selected victim index: " + victims[i]);
            int victimIndex = cll.findVictim(victims[i]);
            if (victimIndex != -1) {
                System.out.println("Victim selected at index: " + victimIndex);
            } else {
                System.out.println("All pages were given a second chance.");
            }
            cll.printList();
        }
    }
}
