/**
Author: Rajin Santos Gajadhar
Student ID: 239479650
Assignment 5, Question 7
Any and all work in this file is my own.
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class DiskCalculator {

    //FCFS Algorithm
    public static int fcfs(List<Integer> queue, int head) {
        int totalDistance = 0;
        int currentPosition = head;

        for (int request : queue) {
            totalDistance += Math.abs(currentPosition - request);
            currentPosition = request;
        }

        return totalDistance;
    }

    //SCAN Algorithm
    public static int scan(List<Integer> queue, int head, int limit) {
        int totalDistance = 0;
        queue.sort(Integer::compareTo);
        
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int request : queue) {
            if (request < head) {
                left.add(request);
            } else {
                right.add(request);
            }
        }

        //Move towards 0, then to limit
        for (int i = left.size() - 1; i >= 0; i--) {
            totalDistance += Math.abs(head - left.get(i));
            head = left.get(i);
        }
        totalDistance += head; //Head moves to 0
        head = 0;
        for (int request : right) {
            totalDistance += Math.abs(head - request);
            head = request;
        }

        return totalDistance;
    }

    //SSTF Algorithm
    public static int sstf(List<Integer> queue, int head) {
        int totalDistance = 0;
        List<Integer> requests = new ArrayList<>(queue);
        int size = requests.size();

        for (int i = 0; i < size; i++) {
            int closest = findClosest(requests, head);
            totalDistance += Math.abs(head - closest);
            head = closest;
            requests.remove(Integer.valueOf(closest));
        }

        return totalDistance;
    }

    //Helper to find closest request for SSTF
    private static int findClosest(List<Integer> requests, int head) {
        int minDistance = Integer.MAX_VALUE;
        int closest = head;

        for (int request : requests) {
            int distance = Math.abs(request - head);
            if (distance < minDistance) {
                minDistance = distance;
                closest = request;
            }
        }

        return closest;
    }

    //C-SCAN Algorithm
    public static int cscan(List<Integer> queue, int head, int limit) {
        int totalDistance = 0;
        queue.sort(Integer::compareTo);
        
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int request : queue) {
            if (request < head) {
                left.add(request);
            } else {
                right.add(request);
            }
        }

        //Move towards limit, then jump to 0
        for (int request : right) {
            totalDistance += Math.abs(head - request);
            head = request;
        }
        totalDistance += limit - head + limit; //Jump to 0
        head = 0;
        for (int request : left) {
            totalDistance += Math.abs(head - request);
            head = request;
        }

        return totalDistance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter current position: ");
        int head = scanner.nextInt();

        System.out.print("Enter the disk size cylinders (e.g.3000): ");
        int limit = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter the disk queue (separate by 1 space): ");
        String[] queueInput = scanner.nextLine().split(" ");
        List<Integer> queue = new ArrayList<>();
        for (String s : queueInput) {
            queue.add(Integer.parseInt(s.trim()));
        }

        System.out.println("Total distance travelled for FCFS: " + fcfs(queue, head));
        System.out.println("Total distance travelled for SCAN: " + scan(queue, head, limit));
        System.out.println("Total distance travelled for SSTF: " + sstf(queue, head));
        System.out.println("Total distance travelled for C-SCAN: " + cscan(queue, head, limit));

        scanner.close();
    }
}
