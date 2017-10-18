### Check Substring

* substring() is O(n)
* time : O(2n) = O(n)
* Find the first different character
	1. If the length is the same , aabc  vs aadc
	2. If the length is different, aabcd vs aacd  

```java
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if( s.length() == 0 && t.length() == 0 ) return false;
        if( s.equals(t) ) return false;
        if( Math.abs(s.length() - t.length()) > 1) return false;
        
        for( int i = 0 ; i < Math.min(s.length(),t.length()) ; i++){
            if( s.charAt(i) != t.charAt(i)){
                if( s.length() == t.length() ){
                    return s.substring(i+1).equals(t.substring(i+1));
                } else if ( s.length() > t.length()){
                    return s.substring(i+1).equals(t.substring(i));
                } else {
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
```


### Two Pointers ( Count Common Characters)
If s and t are one distance away then no matter it is insert or delete or replace the count of common characters must be max(m, n) - 1, where m is the length of s and n is the length of t. It is easy to see that the reverse is also true.

* Assume the length of common prefix (from left to right) is i 
* The length of common suffix after i (from right to left) is j
* The answer is then max(m, n) - 1 == i + j


```java
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if( s.length() == 0 && t.length() == 0 ) return false;
        if( s.equals(t) ) return false;
        int m = s.length();
        int n = t.length();
        int minLen = Math.min(m,n);
        
        int i = 0 , j = 0;
        while( i < minLen && s.charAt(i) == t.charAt(i)) i++;   
        while( j + i < minLen && s.charAt(m - j - 1 ) == t.charAt(n - j - 1)) j++;    
    
        return Math.max(m,n) - 1  == i + j; 
    }
}
```