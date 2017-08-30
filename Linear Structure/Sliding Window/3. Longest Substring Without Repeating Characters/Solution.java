public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0 , maxLen = 0;
        for( int end = 0 ; end < s.length() ; end++ ){
            while( set.contains(s.charAt(end))){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));
            maxLen = Math.max(maxLen,end-start+1);
        }
        return maxLen;
    }
}