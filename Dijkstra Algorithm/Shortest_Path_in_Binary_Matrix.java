import java.util.*;

class Shortest_Path_in_Binary_Matrix {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[source[0]][source[1]] == 0)
            return -1;
        int dis[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dis[i], 1000000);
        dis[source[0]][source[1]] = 0;
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.d - b.d);
        pq.add(new Cell(source[0], source[1], 0));
        int r[] = { 1, -1, 0, 0 };
        int c[] = { 0, 0, 1, -1 };
        while (!pq.isEmpty()) {
            Cell p = pq.poll();
            for (int k = 0; k < 4; k++) {
                int x = p.r + r[k];
                int y = p.c + c[k];
                if (isSafe(x, y, m, n) && grid[x][y] == 1 && dis[p.r][p.c] + 1 < dis[x][y]) {
                    dis[x][y] = dis[p.r][p.c] + 1;
                    pq.add(new Cell(x, y, dis[x][y]));
                }
            }
        }
        if (dis[destination[0]][destination[1]] == 1000000)
            return -1;
        return dis[destination[0]][destination[1]];
    }

    boolean isSafe(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}

class Cell {
    int r, c, d;

    Cell(int x, int y, int z) {
        r = x;
        c = y;
        d = z;
    }
}