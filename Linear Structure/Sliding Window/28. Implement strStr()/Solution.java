public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        int j = 0;
        while( j + needle.length() <= haystack.length() ){
            String sub = haystack.substring(j,j+needle.length());
            if(sub.equals(needle)) return j;
            j++;
        }
        return -1;
    }
}