class No_Of_Closed_Islands {
    boolean flag = true;

    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1)
            return;
        if ((i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) && grid[i][j] == 0)
            flag = false;
        grid[i][j] = 1;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public int closedIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    if (flag)
                        ans += 1;
                    flag = true;
                }
            }
        }
        return ans;
    }
}