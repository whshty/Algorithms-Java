```java
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if( s.length()  < 1 ) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int start = 0 , end = 0;
        int max = 0;
        
        while( end < s.length() ){
            if( map.size() <= k ){
                map.put(s.charAt(end),end);
                end++;
            }
            if( map.size() > k ) {
                int leftMostIndex = findLeftMost(map);
                map.remove(s.charAt(leftMostIndex));
                start = leftMostIndex + 1;
            }
            max = Math.max(end-start,max);
        }
        
        return max;
    }
    private int findLeftMost(Map<Character,Integer> map){
        int res = Integer.MAX_VALUE;
        for(int i : map.values()){
            res = Math.min(res,i);
        }
        return res;
    }
}
```