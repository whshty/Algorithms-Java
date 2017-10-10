class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<String> set = new HashSet<>();
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                if (grid[i][j] == 1){
                    dfs(grid, m, n, i, j, i, j, sb , dir);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid , int m, int n, int iO, int jO, int i, int j, StringBuilder sb, int[][] dir) {
        if ( grid[i][j] == 0) return;
        sb.append(i - iO).append(j - jO);
        grid[i][j] = 0;
        for (int d = 0; d < 4; d++) {
            if(isValid(i + dir[d][0],j + dir[d][1],m,n) && grid[i + dir[d][0]][j + dir[d][1]] == 1){
                dfs(grid, m, n, iO, jO, i + dir[d][0], j + dir[d][1],  sb , dir);
            }
        }
    }
    private boolean isValid(int i , int j, int row , int col){
        return i >=0 && i <  row && j  >= 0 && j  < col ;
    }
}