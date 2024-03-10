import java.util.LinkedList;
import java.util.Queue;

class Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int ans[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    continue;
                }
                boolean vis[][] = new boolean[n][m];
                Queue<Pair> q = new LinkedList<>();
                q.add(new Pair(i, j, 0));
                vis[i][j] = true;
                while (!q.isEmpty()) {
                    Pair p = q.poll();
                    if (mat[p.x][p.y] == 0) {
                        ans[i][j] = p.d;
                        break;
                    }
                    int r[] = { 1, -1, 0, 0 };
                    int c[] = { 0, 0, 1, -1 };
                    for (int k = 0; k < 4; k++) {
                        if (isSafe(p.x + r[k], p.y + c[k], vis, n, m)) {
                            vis[p.x + r[k]][p.y + c[k]] = true;
                            q.add(new Pair(p.x + r[k], p.y + c[k], p.d + 1));
                        }
                    }
                }

            }
        }
        return ans;
    }

    boolean isSafe(int i, int j, boolean vis[][], int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m && vis[i][j] == false;
    }
}

class Pair {
    int x;
    int y;
    int d;

    Pair(int a, int b, int c) {
        x = a;
        y = b;
        d = c;
    }
}