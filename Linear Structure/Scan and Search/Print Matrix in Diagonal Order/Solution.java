class Solution {
    private void printMatrixInDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int col = 0; col < n; col++) {
            System.out.print(matrix[0][col] + " ");
            int i = col - 1;
            int j = 1;
            while (isValid(j, i, m, n)) {
                System.out.print(matrix[j][i] + " ");
                i--;
                j++;
            }
        }

        for( int row =  1 ; row < n ; row++ ) {
            System.out.print(matrix[row][n - 1] + " ");
            int i = row + 1;
            int j = n - 2;
            while (isValid(i, j, m, n)) {
                System.out.print(matrix[i][j] + " ");
                i++;
                j--;

            }
        }
    }

    public boolean isValid(int i, int j, int row, int col) {
        if (i < 0 || i >= row || j >= col || j < 0) return false;
        return true;
    }
}