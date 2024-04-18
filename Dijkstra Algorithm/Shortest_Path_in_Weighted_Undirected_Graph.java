import java.util.*;

class Shortest_Path_in_Weighted_Undirected_Graph {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Edge(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Edge(edges[i][0], edges[i][2]));
        }
        int dis[][] = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            dis[i][0] = 10000000;
            dis[i][1] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Edge(1, 0));
        dis[1][0] = 0;
        while (!pq.isEmpty()) {
            Edge p = pq.poll();
            for (Edge x : adj.get(p.v)) {
                if (dis[p.v][0] + x.wt < dis[x.v][0]) {
                    dis[x.v][0] = dis[p.v][0] + x.wt;
                    dis[x.v][1] = p.v;
                    pq.add(new Edge(x.v, dis[x.v][0]));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (dis[n][0] == 10000000) {
            ans.add(-1);
        } else {
            int x = n;
            while (dis[x][1] != x) {
                ans.add(x);
                x = dis[x][1];
            }
            ans.add(1);
            ans.add(dis[n][0]);
            Collections.reverse(ans);
        }
        return ans;
    }
}

class Edge {
    int v, wt;

    Edge(int a, int b) {
        v = a;
        wt = b;
    }
}