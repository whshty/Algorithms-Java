```java
class Solution {
    public boolean isPalindrome(int x) {
    	if ( x < 0 ) return false;
    	if ( x < 10 ) return true;
    	if ( x % 10  == 0 ) return false;
        
        int endVal = x % 10;
        x /= 10;
        while( x > endVal ){
            endVal = endVal * 10 + x % 10;
            x /= 10;
        }
        if ( endVal > x ) endVal /= 10;  // 121 situtaion 
        return endVal == x ? true : false;
        
    }
}
```