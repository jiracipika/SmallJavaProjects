/*
<COSC 2007>
<Rajin Santos Gajadhar>
<239479650> 
<Lab 8>
*/

import java.util.*;

public class BFS {
    private Map<Character, List<Character>> adjList; 

    public BFS() {
        adjList = new HashMap<>();
    }

    // Method to add an edge to graph
    public void addEdge(char u, char v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // For undirected graph
    }

    // BFS traversal from given source node
    public void bfs(char start) {
        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            char current = queue.poll();
            System.out.println(current); // Visit the current node

            // Process all neighbors of the current node
            for (char neighbor : adjList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // Method to print graph
    public void printGraph() {
        for (char node : adjList.keySet()) {
            System.out.print("Node " + node + " has edges to: ");
            for (char edge : adjList.get(node)) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BFS bfsGraph = new BFS();
        // Add edges from the image to the graph
        bfsGraph.addEdge('a', 'b');
        bfsGraph.addEdge('a', 'i');
        bfsGraph.addEdge('b', 'c');
        bfsGraph.addEdge('b', 'e');
        bfsGraph.addEdge('c', 'd');
        bfsGraph.addEdge('c', 'e');
        bfsGraph.addEdge('c', 'h');
        bfsGraph.addEdge('d', 'h');
        bfsGraph.addEdge('e', 'f');
        bfsGraph.addEdge('e', 'g');
        bfsGraph.addEdge('f', 'g');
        bfsGraph.addEdge('f', 'i');

        // Print the graph
        System.out.println("The graph is:");
        bfsGraph.printGraph();

        // Perform BFS traversal
        System.out.println("\nBreadth-First Search traversal starting from node 'a':");
        bfsGraph.bfs('a'); // Start BFS from node 'a'
    }
}
