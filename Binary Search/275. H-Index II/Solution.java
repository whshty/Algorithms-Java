class Solution {
    public int hIndex(int[] citations) {
        int n  = citations.length;
        int start = 0 , end = citations.length;
        while( start < end ){
            int mid = ( start + end ) >>> 1;
            if( citations[mid] == n - mid ){
                return n - mid;
            } else if ( citations[mid] < n - mid ){
                start = mid + 1;
            } else {
                end = mid;
            }
        }    
        return n - start;
    }
}