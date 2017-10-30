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
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                if( row < 0 || row >= m || col < 0 || col >= n ) continue;
                if( matrix[row][col] <= matrix[cur[0]][cur[1]] + 1) continue;
                queue.add(new int[] {row, col});
                matrix[row][col] = matrix[cur[0]][cur[1]] + 1;
            }
        }
        
        return matrix;
    }
}