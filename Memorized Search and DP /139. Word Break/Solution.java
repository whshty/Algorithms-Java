class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s,wordDict,new HashSet<String>());
    }
    private boolean dfs(String s, List<String> wordDict, Set<String> visited) {
        if (s.isEmpty()) return true;
        if (visited.contains(s)) return false;
        visited.add(s);
        for (String word : wordDict) {
            if (s.startsWith(word) && dfs(s.substring(word.length()), wordDict, visited)) return true;
        }
        return false;
    }
}

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