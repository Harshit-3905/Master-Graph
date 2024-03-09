class Max_Area_of_Island {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;
        boolean vis[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == false) {
                    vis[i][j] = true;
                    int count = dfs(grid, vis, n, m, i, j);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    int dfs(int grid[][], boolean vis[][], int n, int m, int i, int j) {
        int count = 1;
        int r[] = { 1, -1, 0, 0 };
        int c[] = { 0, 0, 1, -1 };
        for (int k = 0; k < 4; k++) {
            int x = i + r[k];
            int y = j + c[k];
            if (isSafe(n, m, grid, x, y) && vis[x][y] == false) {
                vis[x][y] = true;
                count += dfs(grid, vis, n, m, x, y);
            }
        }
        return count;
    }

    boolean isSafe(int n, int m, int grid[][], int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1;
    }
}