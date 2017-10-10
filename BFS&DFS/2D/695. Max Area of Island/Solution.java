class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0) return res;
        if (grid[0] == null || grid[0].length == 0) return res;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid,i,j,m,n,0,dir);
                    res = Math.max(size,res);
                }
            }
        }
        return res;
    }   
    private int dfs(int[][] grid, int i , int j, int m, int n , int size, int[][] dir) {
        grid[i][j] = 0;
        size++;
        for (int d = 0; d < 4; d++) {
            if(isValid(i + dir[d][0],j + dir[d][1],m,n) && grid[i + dir[d][0]][j + dir[d][1]] == 1){
                size = dfs(grid,i + dir[d][0], j + dir[d][1], m, n , size ,dir);
            }
        }
        return size;
    }

    private boolean isValid(int i , int j, int row , int col){
        return i >=0 && i <  row && j  >= 0 && j  < col ;
    }
}