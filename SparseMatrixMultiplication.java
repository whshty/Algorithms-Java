// brute force
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int ma= A.length, na = A[0].length, mb = B.length, nb = B[0].length;
        int[][] c = new int[ma][nb];
        for(int i = 0 ;  i < ma ; i++ ){
            for(int j = 0 ; j < na ; j ++ ){
                if(A[i][j] != 0){
                    for( int k = 0 ; k < nb ; k++){
                        c[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return c;
    }
}