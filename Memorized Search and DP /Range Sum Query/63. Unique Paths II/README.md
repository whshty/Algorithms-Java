## 1.DP
```java
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for(int[] row : obstacleGrid ){
            for( int j = 0 ; j < width ; j++ ){
                if(row[j] == 1 ) dp[j] = 0;
                else if( j > 0 ) dp[j] += dp[j-1];
            }
        }
        return dp[width-1];
    }
}
```

## 2.Generate All Path
```java
public class Solution {
    public List<String>printAllPath(int[][] matrix) {
        List<String> res = new ArrayList<>();
        helper(matrix, matrix.length, matrix[0].length, 0, 0, "", res);
        return res;
    }

    public void helper(int[][] input, int row, int col, int x, int y, String path ,List<String> res) {
        if (x == row - 1) {
            for (int i = y; i < col; i++) {
                //path += "-" + input[x][i];
                path += "-" + x + "" + i ;
            }
            res.add(path);
            return;
        }
        if(input[x][y] == 1 ) return;

        if (y == col - 1) {
            for (int i = x; i <= row - 1; i++) {
                //path += "-" + input[i][y];
                path += "-" + i + "" + y;
            }
            res.add(path);
            return;
        }
        //path = path + "-" + input[x][y];
        path = path + "-" + x + "" + y;
        helper(input, row, col, x + 1, y, path,res);
        helper(input, row, col, x, y + 1, path,res);
    }
}
```