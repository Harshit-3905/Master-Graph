import java.util.*;

class Find_Eventual_Safe_States {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        int n = adj.size();
        boolean vis[] = new boolean[n];
        boolean path[] = new boolean[n];
        boolean check[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i])
                continue;
            helper(i, adj, vis, path, check);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (check[i])
                ans.add(i);
        return ans;
    }

    boolean helper(int i, List<List<Integer>> adj, boolean vis[], boolean path[], boolean check[]) {
        if (vis[i]) {
            if (path[i])
                return false;
            if (check[i])
                return true;
        }
        vis[i] = true;
        path[i] = true;
        for (int x : adj.get(i)) {
            if (!helper(x, adj, vis, path, check))
                return false;
        }
        path[i] = false;
        check[i] = true;
        return true;
    }
}