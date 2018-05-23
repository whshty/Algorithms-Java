public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || start == null || destination == null) {
            return false;
        }
        boolean[][] hasVisited = new boolean[maze.length][maze[0].length];

        return dfs(maze, hasVisited, start, destination);

    }

    private boolean dfs(int[][] maze, boolean[][] hasVisited, int[] cur, int[] des) {
        int row = cur[0];
        int col = cur[1];
        if (row == des[0] && col == des[1]) return true;
        if (hasVisited[row][col]) return false;
        hasVisited[row][col] = true;

        if (col > 0 && maze[row][col - 1] != 1) {
            int i = col - 1;
            while (i > 0 && maze[row][i - 1] != 1) i--;
            if (dfs(maze, hasVisited, new int[]{row, i}, des)) return true;
        }

        if (col < maze[0].length - 1 && maze[row][col + 1] != 1) {
            int i = col + 1;
            while (i < maze[0].length - 1 && maze[row][i + 1] != 1) i++;
            if (dfs(maze, hasVisited, new int[]{row, i}, des)) return true;
        }

        if (row > 0 && maze[row - 1][col] != 1) {
            int i = row - 1;
            while (i > 0 && maze[i - 1][col] != 1) i--;
            if (dfs(maze, hasVisited, new int[]{i, col}, des)) return true;
        }

        if (row < maze.length - 1 && maze[row + 1][col] != 1) {
            int i = row + 1;
            while (i < maze.length - 1 && maze[i + 1][col] != 1) i++;
            if (dfs(maze, hasVisited, new int[]{i, col}, des)) return true;
        }

        return false;
    }
}