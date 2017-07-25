public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if( s.length() < 1 ) return 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int start = 0 , end = 0;
        int maxLength = 0;
        while( end < s.length() ){
            if( map.size() <= k ){
                char ch = s.charAt(end);
                map.put(ch,end);
                end++;
            } 
            if( map.size() > k ){
                int leftMost = s.length();
                for( int i : map.values()){
                    leftMost = Math.min(leftMost,i);
                }
                char ch = s.charAt(leftMost);
                map.remove(ch);
                start = leftMost + 1;
            }
            maxLength = Math.max(maxLength,end-start);
        }
        return maxLength;

    }
}