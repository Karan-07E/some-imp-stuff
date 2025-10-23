import java.util.*;

public class Bellman {
    static final int INF = 999;
    int[] dist;
    int V;

    public Bellman(int V) {
        this.V = V;
        dist = new int[V + 1];
    }

    public void evaluate(int src, int[][] graph) {
        Arrays.fill(dist, INF);
        dist[src] = 0;

        // Relax edges V-1 times
        for (int i = 1; i < V; i++)
            for (int u = 1; u <= V; u++)
                for (int v = 1; v <= V; v++)
                    if (graph[u][v] != INF && dist[v] > dist[u] + graph[u][v])
                        dist[v] = dist[u] + graph[u][v];

        // Check negative cycles
        for (int u = 1; u <= V; u++)
            for (int v = 1; v <= V; v++)
                if (graph[u][v] != INF && dist[v] > dist[u] + graph[u][v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }

        for (int i = 1; i <= V; i++)
            System.out.println("Distance from " + src + " to " + i + " = " + dist[i]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        int[][] graph = new int[V + 1][V + 1];

        System.out.println("Enter adjacency matrix:");
        for (int i = 1; i <= V; i++)
            for (int j = 1; j <= V; j++) {
                graph[i][j] = sc.nextInt();
                if (i == j) graph[i][j] = 0;
                else if (graph[i][j] == 0) graph[i][j] = INF;
            }

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();
        new Bellman(V).evaluate(src, graph);
        sc.close();
    }
}


//input
/* 
Enter number of vertices: 5
Enter adjacency matrix:
0 6 0 7 0
0 0 5 8 -4
0 -2 0 0 0
0 0 -3 0 9
2 0 7 0 0
Enter source vertex: 1
*/