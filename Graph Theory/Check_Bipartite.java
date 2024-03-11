import java.util.*;

class Check_Bipartite {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        int[] a = new int[graph.length];
        Arrays.fill(a, -1);
        for (int i = 0; i < graph.length; i++) {
            if (a[i] != -1)
                continue;
            q.add(i);
            a[i] = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    int p = q.poll();
                    for (int x : graph[p]) {
                        if (a[x] == -1) {
                            q.add(x);
                            a[x] = 1 - a[p];
                        } else {
                            if (a[x] == a[p])
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}