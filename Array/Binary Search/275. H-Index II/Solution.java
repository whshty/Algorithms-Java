public class Solution {
    public int hIndex(int[] citations) {
        int n  = citations.length;
        int low = 0 , high = citations.length;
        while( low < high ){
            int mid = ( low + high ) >>> 1;
            if( citations[mid] == n - mid ){
                return n - mid;
            } else if ( citations[mid] < n - mid ){
                low = mid + 1;
            } else {
                high = mid;
            }
        }    
        return n - low;
    }
}