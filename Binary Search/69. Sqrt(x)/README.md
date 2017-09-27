```
class Solution {
    public int mySqrt(int x) {
        if( x == 0 ) return 0;
        if( x == 1 ) return 1;
        int start = 0, end = Integer.MAX_VALUE;
        
        while(true){
            int mid = ( start + end ) >>> 1 ;
            // mid * mid : overflow
            if( mid > x / mid ){
                end = mid - 1;
            } else {
                if( mid + 1 > x / ( mid + 1 ) ) return mid;
                start = mid + 1;
            }
        }
    }
}
```