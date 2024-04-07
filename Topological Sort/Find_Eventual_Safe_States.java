import java.util.*;

class Find_Eventual_Safe_States {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int x : graph[i]) {
                adj.get(x).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int p = q.poll();
            ans.add(p);
            for (int x : adj.get(p)) {
                indegree[x]--;
                if (indegree[x] == 0)
                    q.add(x);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}