import java.util.*;

public class DiskScheduling {

    // FCFS Algorithm
    public static int calculateFCFS(int[] queue, int start) {
        int totalDistance = 0;
        int currentPosition = start;

        for (int request : queue) {
            totalDistance += Math.abs(request - currentPosition);
            currentPosition = request;
        }

        return totalDistance;
    }

    // SSTF Algorithm
    public static int calculateSSTF(int[] queue, int start) {
        int totalDistance = 0;
        int currentPosition = start;
        boolean[] visited = new boolean[queue.length];

        for (int i = 0; i < queue.length; i++) {
            int closest = findClosest(queue, currentPosition, visited);
            totalDistance += Math.abs(queue[closest] - currentPosition);
            currentPosition = queue[closest];
            visited[closest] = true;
        }

        return totalDistance;
    }

    private static int findClosest(int[] queue, int currentPosition, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < queue.length; i++) {
            if (!visited[i] && Math.abs(queue[i] - currentPosition) < minDistance) {
                minDistance = Math.abs(queue[i] - currentPosition);
                index = i;
            }
        }

        return index;
    }

    // SCAN Algorithm
    public static int calculateSCAN(int[] queue, int start, int diskSize) {
        int totalDistance = 0;
        int currentPosition = start;
        List<Integer> sortedQueue = new ArrayList<>();

        for (int request : queue) {
            sortedQueue.add(request);
        }
        Collections.sort(sortedQueue);

        int idx = sortedQueue.indexOf(start);
        for (int i = idx; i >= 0; i--) {
            totalDistance += Math.abs(sortedQueue.get(i) - currentPosition);
            currentPosition = sortedQueue.get(i);
        }
        if (idx > 0) {
            totalDistance += currentPosition; // Move to 0 if needed
            currentPosition = 0;
        }

        for (int i = idx + 1; i < sortedQueue.size(); i++) {
            totalDistance += Math.abs(sortedQueue.get(i) - currentPosition);
            currentPosition = sortedQueue.get(i);
        }

        return totalDistance;
    }

    // C-SCAN Algorithm
    public static int calculateCSCAN(int[] queue, int start, int diskSize) {
        int totalDistance = 0;
        int currentPosition = start;
        List<Integer> sortedQueue = new ArrayList<>();

        for (int request : queue) {
            sortedQueue.add(request);
        }
        Collections.sort(sortedQueue);

        int idx = sortedQueue.indexOf(start);
        for (int i = idx; i < sortedQueue.size(); i++) {
            totalDistance += Math.abs(sortedQueue.get(i) - currentPosition);
            currentPosition = sortedQueue.get(i);
        }

        if (idx < sortedQueue.size() - 1) {
            totalDistance += diskSize - 1 - currentPosition; // Move to the end
            totalDistance += diskSize - 1; // Move to start (0)
            currentPosition = 0;
        }

        for (int i = 0; i < idx; i++) {
            totalDistance += Math.abs(sortedQueue.get(i) - currentPosition);
            currentPosition = sortedQueue.get(i);
        }

        return totalDistance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of cylinders: ");
        int diskSize = scanner.nextInt();

        System.out.print("Enter the initial head position: ");
        int start = scanner.nextInt();

        System.out.print("Enter the size of queue: ");
        int n = scanner.nextInt();

        int[] queue = new int[n];
        System.out.println("Enter the queue of disk positions to read:");
        for (int i = 0; i < n; i++) {
            queue[i] = scanner.nextInt();
        }

        System.out.println("Total distance moved by Disk Head using FCFS: " + calculateFCFS(queue, start));
        System.out.println("Total distance moved by Disk Head using SSTF: " + calculateSSTF(queue, start));
        System.out.println("Total distance moved by Disk Head using SCAN: " + calculateSCAN(queue, start, diskSize));
        System.out.println("Total distance moved by Disk Head using C-SCAN: " + calculateCSCAN(queue, start, diskSize));

        scanner.close();
    }
}
