Two pointers

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
            while( count == 0 ){
                if( end - start < minLen){
                    minStart = start;
                    minLen = end - start;
                }
                map[s.charAt(start)]++;
                if( map[s.charAt(start++)] > 0 ) count++;
            }
        }
        if( minLen == Integer.MAX_VALUE ) return "";
        else return s.substring(minStart,minStart+minLen);
    }
}
```