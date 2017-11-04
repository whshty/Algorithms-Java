class Solution {
    public int islandPerimeter(int[][] grid) {
        int landCount = 0, duplicates = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    landCount++; 
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) duplicates++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) duplicates++; // count right neighbours
                }
            }
        }
        return landCount * 4 - duplicates * 2;
    }
}