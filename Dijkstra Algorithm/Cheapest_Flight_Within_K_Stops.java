import java.util.*;

class Cheapest_Flight_Within_K_Stops {
    static class Graph {
        class Node {
            private int vertex;
            private int cost;

            public Node(int v, int w) {
                this.vertex = v;
                this.cost = w;
            }
        }

        class Tuple {
            private int stop;
            private int vertex;
            private int cost;

            public Tuple(int stop, int vertex, int cost) {
                this.stop = stop;
                this.vertex = vertex;
                this.cost = cost;
            }
        }

        private int V;
        private List<ArrayList<Node>> adj;

        public Graph(int v) {
            this.V = v;
            this.adj = new ArrayList<ArrayList<Node>>(this.V);
            for (int i = 0; i < this.V; i++) {
                this.adj.add(new ArrayList<Node>());
            }
        }

        public void addEdge(int u, int v, int weight) {
            this.adj.get(u).add(new Node(v, weight));
        }

        public int dijkstra(int n, int src, int dst, int k) {
            Queue<Tuple> queue = new LinkedList<>();
            queue.add(new Tuple(0, src, 0));
            int[] distance = new int[n];
            for (int i = 0; i < n; i++) {
                distance[i] = (int) (1e9);
            }
            distance[src] = 0;
            while (!queue.isEmpty()) {
                Tuple tuple = queue.poll();
                int stops = tuple.stop;
                int v = tuple.vertex;
                int cost = tuple.cost;
                if (stops > k) {
                    continue;
                }
                for (Node node : adj.get(v)) {
                    int u = node.vertex;
                    int edW = node.cost;
                    if (cost + edW < distance[u] && stops <= k) {
                        distance[u] = cost + edW;
                        queue.add(new Tuple(stops + 1, u, cost + edW));
                    }
                }
            }
            if (distance[dst] == (int) (1e9)) {
                return -1;
            }
            return distance[dst];
        }
    }

    public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
        Graph graph = new Graph(n);
        int m = flights.length;
        for (int i = 0; i < m; i++) {
            graph.addEdge(flights[i][0], flights[i][1], flights[i][2]);
        }
        return graph.dijkstra(n, src, dst, k);
    }
}