import java.util.*;

class Rotten_Oranges {
    public int orangesRotting(int[][] grid) {
        int count1 = 0;
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    q.add(new Pair(i, j));
                else if (grid[i][j] == 1)
                    count1++;
            }
        }
        if (count1 == 0)
            return 0;
        int ans = 0;
        int r[] = { 1, -1, 0, 0 };
        int c[] = { 0, 0, 1, -1 };
        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                Pair p = q.poll();
                for (int k = 0; k < 4; k++) {
                    int x = p.x + r[k];
                    int y = p.y + c[k];
                    if (isSafe(x, y, m, n) && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        count1--;
                        q.add(new Pair(x, y));
                    }
                }
            }
            ans++;
        }
        if (count1 != 0)
            return -1;
        return ans - 1;
    }

    boolean isSafe(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    class Pair {
        int x, y;

        Pair(int a, int b) {
            x = a;
            y = b;
        }
    }
}