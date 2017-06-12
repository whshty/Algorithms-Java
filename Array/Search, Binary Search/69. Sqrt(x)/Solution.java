public class Solution {
    public int mySqrt(int x) {
        if( x == 0 ) return 0;
        int left = 0, right = Integer.MAX_VALUE;
        
        while(true){
            int mid = ( left + right ) >>> 1 ;
            if( mid > x / mid ){
                right = mid - 1;
            } else {
                if( mid + 1 > x / ( mid + 1 ) ) return mid;
                left = mid + 1;
            }
        }
    }
}