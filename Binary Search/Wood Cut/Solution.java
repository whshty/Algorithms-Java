public class Solution {
    /*
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int max = 0;
        for( int i = 0 ; i < L.length ; i++ ) max = Math.max(max,L[i]);
        
        int start = 1 , end = max;
        
        while( start  + 1 < end ){
            int mid = ( start + end ) >>> 1;
            if( getCount(L,mid) >= k ) start = mid;
            else end = mid;
        }
        
        if (getCount(L, end) >= k) {
            return end;
        }
        if (getCount(L, start) >= k) {
            return start;
        }
        return 0;
        
    }
    
    private int getCount(int[] L , int len){
        int res = 0;
        for( int i = 0 ; i < L.length ; i++ ){
            res += L[i] / len;
        }
        return res;
    }
}