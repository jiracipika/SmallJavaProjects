import java.util.Arrays;

public class SimpleDirectedGraph {
    private int vertices;
    private int[][] adjacencyMatrix;
    
    public SimpleDirectedGraph(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix[i][j] = Integer.MAX_VALUE; // Initialize with infinity
            }
        }
    }

    public void addEdge(int u, int v, int w) {
        adjacencyMatrix[u][v] = w;
        adjacencyMatrix[v][u] = w; // Assuming an undirected graph
    }

    public void dijkstra(int source) {
        int[] dist = new int[vertices];
        boolean[] visited = new boolean[vertices];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        
        for (int count = 0; count < vertices - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;
            
            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && adjacencyMatrix[u][v] != Integer.MAX_VALUE && dist[u] + adjacencyMatrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + adjacencyMatrix[u][v];
                }
            }
        }
        
        printSolution(dist);
    }

    private int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        
        for (int v = 0; v < vertices; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        
        return minIndex;
    }

    private void printSolution(int[] dist) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " \t " + dist[i]);
        }
    }
    
    public static void main(String[] args) {
        SimpleDirectedGraph g = new SimpleDirectedGraph(4); // Assuming 4 vertices
        g.addEdge(0, 1, 1); // Assuming vertex 's' is 0
        g.addEdge(0, 2, 3);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 4);
        g.addEdge(2, 3, 1);
        
        g.dijkstra(0); // Assuming 's' is the source
    }
}
