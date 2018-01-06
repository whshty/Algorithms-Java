## 1.DP
```java
public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int res = 0;
        if( grid == null || grid.length == 0 || grid[0].length == 0 ) return res;
        int m = grid.length;
        int n = grid[0].length;
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];

        for ( int i = 0 ; i < m ; i++ ) {
            for ( int j = 0 ; j < n ; j++ ) {
                up[i][j] = 0;
                if ( grid[i][j] != 'W') {
                    if ( grid[i][j] == 'E') up[i][j] = 1;
                    if (i - 1 >= 0) up[i][j] += up[i-1][j];
                }
            }
        }
        
        for ( int i = m - 1 ; i >= 0 ; --i) {
            for ( int j = 0; j < n; ++j) {
                down[i][j] = 0;
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') down[i][j] = 1;   
                    if (i + 1 < m) down[i][j] += down[i+1][j];
                
                }
            }
        }
        
        for ( int i = 0; i < m; ++i) {
            for ( int j = 0; j < n; ++j) {
                left[i][j] = 0;
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') left[i][j] = 1;
                    if (j - 1 >= 0) left[i][j] += left[i][j-1];
                    
                }
            }
        }
        
        for ( int i = 0; i < m; ++i) {
            for ( int j = n - 1; j >= 0; --j) {
                right[i][j] = 0;
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') right[i][j] = 1;
                    if (j + 1 < n) right[i][j] += right[i][j+1];
                    
                }
            }
        }
        
        for( int i = 0 ; i < m ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                if( grid[i][j] == '0' ){
                    res = Math.max(res,up[i][j] + down[i][j] + left[i][j] + right[i][j]);
                }
            }
        }
        return res;
    }
}
```

## 2.DP

```java
public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int res = 0;
        if( grid == null || grid.length == 0 || grid[0].length == 0 ) return res;
        int row = 0;
        // store col enemies count , only update once for consecutive enemies column 
        int[] col = new int[grid[0].length]; 
        // store one killed enemies value from a row  and an array of each column
        for( int i = 0 ; i < grid.length ; i ++ ){
            for( int j = 0 ; j < grid[0].length; j++ ){
                // row has only one value  row = j
                // col has serval different values
                if( grid[i][j] == 'W' ) continue;
                // if upper and left has "W", recalculate 
                if( j == 0 || grid[i][j-1] == 'W') row = killRow(grid,i,j);
                if( i == 0 || grid[i-1][j] == 'W' ) col[j] = killCol(grid,i,j);        
                
                // only put bombs in empty cell
                if(grid[i][j] == '0'){
                    res = Math.max(res, row + col[j]);        
                }
            } 
        }
        return res;
    }
    // calculate killed enemies for row i from colmun j
    private int killRow(char[][] grid , int i , int j){
        int num = 0;
        while( j <= grid[0].length -1 && grid[i][j] != 'W'){
            if(grid[i][j] == 'E') num++;
            j++;
        }
        return num;
    }
    // calculate killed enemies for column j from row i 
    private int killCol(char[][] grid, int i , int j){
        int num = 0;
        while( i <= grid.length - 1 && grid[i][j] != 'W'){
            if(grid[i][j] == 'E') num++;
            i++;
        }
        return num;
    }
}
```