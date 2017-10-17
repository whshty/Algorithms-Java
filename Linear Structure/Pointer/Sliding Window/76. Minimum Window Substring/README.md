### Two pointers
* Move the end pointer when count is bigger than 0
* Move the start pointer is the count is 0

```java
public class Solution {
    public String minWindow(String s, String t) {   
        if( s == null || s.length() == 0 || s.length() < t.length() ) return "";
        int[] map = new int[128];
        for( char ch : t.toCharArray()) map[ch]++;
        
        int start = 0 , end = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int count = t.length();
        
        while( end < s.length() ){
            if( map[s.charAt(end)]-- > 0 ) count--;
            end++;
            // When we found the required string
            while( count == 0 ){
                // Update min length
                if( end - start < minLen){
                    minStart = start;
                    minLen = end - start;
                }
                // move left point
                map[s.charAt(start)]++;
                if( map[s.charAt(start++)] >= 1 ) count++;
            }
        }
        if( minLen == Integer.MAX_VALUE ) return "";
        else return s.substring(minStart,minStart+minLen);
    }
}
```