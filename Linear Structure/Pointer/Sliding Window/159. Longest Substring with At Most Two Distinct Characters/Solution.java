class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 1) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int start = 0 , end = 0 , maxLen = 0;
             
        while (end < s.length()){
            if (map.size() <= 2) {
                char ch = s.charAt(end);
                map.put(ch,end);
                end++;
            } 
            if (map.size() > 2) {
                int leftMost = findtheLeftMost(map);
                char ch = s.charAt(leftMost);
                map.remove(ch);
                start = leftMost + 1;
            }
            maxLen = Math.max(maxLen,end-start);
        }
        return maxLen;
    }
    
    private int findtheLeftMost(Map<Character,Integer> map) {
        int res = Integer.MAX_VALUE;
        for (int i : map.values()) {
            res = Math.min(res,i);
        }
        return res;
    }
}