public class Solution {
    public int mySqrt(int x) {
        // corner case
        if( x == 0 ) return 0;
        // binary search
        int left = 0 , right = Integer.MAX_VALUE;
        while ( true ){
            int mid = left + ( right - left ) / 2;
            if( mid > x /mid ){
                right = mid - 1;
            } else {
                if( mid + 1 > x /( mid + 1)) return mid;
                left = mid + 1;
            }
        }
        
    }
}