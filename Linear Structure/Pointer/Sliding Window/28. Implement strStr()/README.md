* haystack abcdsda
* needle bcd
* res = 1

```
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        int start = 0;
        int len = needle.length();
        while( start + len <= haystack.length() ){
            String sub = haystack.substring(start,start+len);
            if(sub.equals(needle)) return start;
            start++;
        }
        return -1;
    }
}
```