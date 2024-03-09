class Number_of_Provinces {
    public int findCircleNum(int[][] isConnected) {
        boolean vis[] = new boolean[isConnected.length];
        int c = 0;
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                c++;
                dfs(isConnected, vis, i);
            }
        }
        return c;
    }

    void dfs(int[][] isConnected, boolean[] vis, int i) {
        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j] == 1 && !vis[j]) {
                vis[j] = true;
                dfs(isConnected, vis, j);
            }
        }
    }
}