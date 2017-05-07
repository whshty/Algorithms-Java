public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] cache = new boolean[len+1];
        cache[0] = true;
        for( int i = 1 ; i < len + 1 ; i++){
           for( int j = 0 ; j < i ; j++ ){
               if( cache[j] && wordDict.contains(s.substring(j,i))){
                   cache[i] = true;
               }
           }  
           
        }
        return cache[len];
    }
}