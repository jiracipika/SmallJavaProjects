 /*
<COSC 2007>
<Rajin Santos Gajadhar>
<239479650> 
<Lab 6>
*/

import java.util.Arrays;

public class MaxHeapPriorityQueue {
    private int capacity = 10;
    private int size = 0;
    
    int[] items = new int[capacity];
    
    private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
    private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }
    
    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }
    
    private int leftChild(int index) { return items[getLeftChildIndex(index)]; }
    private int rightChild(int index) { return items[getRightChildIndex(index)]; }
    private int parent(int index) { return items[getParentIndex(index)]; }
    
    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }
    
    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }
    
    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }
    
    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }
    
    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }
    
    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) < items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
    
    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int largerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                largerChildIndex = getRightChildIndex(index);
            }
            
            if (items[index] > items[largerChildIndex]) {
                break;
            } else {
                swap(index, largerChildIndex);
            }
            index = largerChildIndex;
        }
    }
    
    public void changePriority(int index, int priority) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Invalid index");
        items[index] = priority;
        heapifyUp();
        heapifyDown();
    }
    
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Invalid index");
        items[index] = Integer.MAX_VALUE;
        heapifyUp();
        poll();
    }
    
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeapPriorityQueue pq = new MaxHeapPriorityQueue();
        
        // Insert elements
        int[] elements = {45, 20, 14, 12, 31, 7, 11, 13, 7};
        for (int element : elements) {
            pq.add(element);
        }
        
        // Display elements
        System.out.println("Priority Queue:");
        pq.display();
        
        // Display max element
        System.out.println("Max Element: " + pq.peek());
        
        // Extract max and display
        pq.poll();
        System.out.println("After Extracting Max:");
        pq.display();
        
        // Change priority and display
        pq.changePriority(2, 49);
        System.out.println("After Changing Priority:");
        pq.display();
        
        // Remove element and display
        pq.remove(3);
        System.out.println("After Removing Element:");
        pq.display();
    }
}
