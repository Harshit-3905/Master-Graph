import java.util.*;

class All_Paths_From_Source_To_Target {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int n = graph.length;
        boolean vis[] = new boolean[n];
        list.add(0);
        helper(graph, 0, n - 1, list, ans, vis);
        return ans;
    }

    void helper(int graph[][], int src, int tar, List<Integer> list, List<List<Integer>> ans, boolean vis[]) {
        if (src == tar) {
            ans.add(new ArrayList<>(list));
            return;
        }
        vis[src] = true;
        for (int x : graph[src]) {
            if (vis[x])
                continue;
            list.add(x);
            helper(graph, x, tar, list, ans, vis);
            vis[x] = false;
            list.remove(list.size() - 1);
        }
    }
}