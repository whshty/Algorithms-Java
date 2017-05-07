public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dist = new int[maze.length][maze[0].length];
        dist[start[0]][start[1]] = 1;
        dfs(start[0], start[1], destination, maze, dist);
        return dist[destination[0]][destination[1]] - 1;
    }
    private void dfs(int row, int col, int[] dest, int[][] maze, int[][] dist) {
        final int[] DIRS = {0, 1, 0, -1, 0};
        if (row == dest[0] && col == dest[1]) return;
        int m = maze.length, n = maze[0].length;
        for (int d = 0; d < 4; d++) {
            int i = row, j = col, p = DIRS[d], q = DIRS[d + 1], len = dist[row][col];
            while (i + p >= 0 && i + p < m && j + q >= 0 && j + q < n && maze[i + p][j + q] == 0) {
                i += p;
                j += q;
                len++;
            }
            if (dist[i][j] > 0 && len >= dist[i][j]) continue;
            dist[i][j] = len;
            dfs(i, j, dest, maze, dist);
        }
    }
}