class Flood_Fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        boolean vis[][] = new boolean[m][n];
        helper(image, vis, sr, sc, newColor);
        return image;
    }

    void helper(int[][] image, boolean[][] vis, int sr, int sc, int newColor) {
        vis[sr][sc] = true;
        int r[] = { 1, -1, 0, 0 };
        int c[] = { 0, 0, 1, -1 };
        for (int k = 0; k < 4; k++) {
            int x = sr + r[k];
            int y = sc + c[k];
            if (isSafe(image, x, y) && image[x][y] == image[sr][sc] && vis[x][y] == false) {
                helper(image, vis, x, y, newColor);
            }
        }
        image[sr][sc] = newColor;
    }

    boolean isSafe(int[][] image, int x, int y) {
        return x >= 0 && y >= 0 && x < image.length && y < image[0].length;
    }
}