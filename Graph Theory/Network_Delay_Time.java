import java.util.*;

class Network_Delay_Time {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            adj.get(times[i][0]).add(new Edge(0, times[i][1], times[i][2]));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> (a.time - b.time));
        int ans[] = new int[n + 1];
        Arrays.fill(ans, 100000);
        ans[k] = 0;
        for (Edge x : adj.get(k)) {
            pq.add(new Edge(k, x.v, x.time));
        }
        while (!pq.isEmpty()) {
            Edge p = pq.poll();
            if (ans[p.u] + p.time < ans[p.v]) {
                ans[p.v] = ans[p.u] + p.time;
                for (Edge x : adj.get(p.v)) {
                    pq.add(new Edge(p.v, x.v, x.time));
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (ans[i] == 100000)
                return -1;
            max = Math.max(max, ans[i]);
        }
        return max;
    }
}

class Edge {
    int u, v, time;

    Edge(int a, int b, int c) {
        u = a;
        v = b;
        time = c;
    }
}