```
public class Solution {
    public boolean isPerfectSquare(int num) {
        if( num < 1 ) return false;
        if( num == 1 ) return true;
        long start = 1 , end = num;
        while( start <= end ){
            long mid = ( start + end ) >>> 1;
            long res = mid * mid;
            if( res == num ) return true;
            else if( res > num ) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}
```