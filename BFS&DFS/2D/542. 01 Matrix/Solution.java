class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) queue.offer(new int[] {i, j});
                else matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int tempX = cur[0] + dir[0];
                int tempY = cur[1] + dir[1];
                if( tempX < 0 || tempX >= m || tempY < 0 || tempY >= n ) continue;
                if( matrix[tempX][tempY] <= matrix[cur[0]][cur[1]] + 1) continue;
                queue.add(new int[] {tempX, tempY});
                matrix[tempX][tempY] = matrix[cur[0]][cur[1]] + 1;
            }
        }
        return matrix;
    }
}