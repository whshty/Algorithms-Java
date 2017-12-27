class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for( int i = 0 ; i < A.length ; i++ ){
            for( int j = 0 ; j < B.length ; j++ ){
                int tempSum = A[i] + B[j];
                map.put(tempSum,map.getOrDefault(tempSum,0) + 1);
            }
        }
        
        int res = 0;
        for( int i = 0 ; i < C.length ; i++ ){
            for( int j = 0 ; j < D.length ; j++ ){
                int tempSum =  (C[i] + D[j]);
                res += map.getOrDefault( -1 * tempSum,0);
            }
        }
        return res;
    }
}