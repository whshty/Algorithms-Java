```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0 , end = 0;
        Set<Character> set = new HashSet<>();
        
        int res = 0;
        while( end < s.length() ){
            if( !set.contains(s.charAt(end)) ){
                set.add(s.charAt(end));
                end++;
                res = Math.max(res,end-start);
            } else {
                set.remove(s.charAt(start++));
            }
        }
        return res;
    }
}
```