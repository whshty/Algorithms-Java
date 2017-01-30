public class NumMatrix {
    int[][] tree;
    int[][] nums;
    int m;
    int n;
    // [1,1][1,2]     [1,4]                [1,8]
    //           [3,3]     [5,5] [5,6]
    //                                [7,7]
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        tree = new int[m+1][n+1];
        nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }
    // add[5,2] - update range[5,5] -> [5,6] -> [1,8]
    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) return;
        int diff = val - nums[row][col];
        nums[row][col] = val;
        for (int i = row + 1; i <= m; i += i & (-i)) {
            for (int j = col + 1; j <= n; j += j & (-j)) {
                tree[i][j] += diff;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0) return 0;
        return sum(row2+1, col2+1) + sum(row1, col1) - sum(row1, col2+1) - sum(row2+1, col1);
    }
    // if we want to find the sum of first 13, then[13,13] -> [9,12] ->[1,8]
    public int sum(int row, int col) {
        int sum = 0;
        for (int i = row; i > 0; i -= i & (-i)) {
            for (int j = col; j > 0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }
        return sum;
    }
}
// https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/
