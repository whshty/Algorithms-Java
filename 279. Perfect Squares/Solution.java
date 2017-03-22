public class Solution {
    public int numSquares(int n) {
        int[] res = new int[n+1];
        for( int i = 1 ; i <= n ; i++ ){
            res[i] = Integer.MAX_VALUE;
        }
        return memodfs(res,n)[n];
    }
    public int[] memodfs(int[]res, int remain){
        if( remain == 1 ){
            res[1] = 1;
            return res;
        }
        if( res[remain] < Integer.MAX_VALUE){
            return res;
        }
        int k = (int)Math.sqrt(remain);
        for( int i = 1; i <= k ; i++ ){
            int temp = remain -  ( i * i );
            res[remain] = Math.min(res[remain], 1 + memodfs(res,temp)[temp]);
        }
        return res;
    }
}