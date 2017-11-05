// DFS
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s,wordDict,new HashSet<String>());
    }
    private boolean dfs(String s, List<String> wordDict, Set<String> isVisited) {
        if (s.isEmpty()) return true;
        if (isVisited.contains(s)) return false;
        isVisited.add(s);
        for (String word : wordDict) {
            if (s.startsWith(word) && dfs(s.substring(word.length()), wordDict, isVisited)) return true;
        }
        return false;
    }
}

// DP
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for( int i = 1 ; i < len + 1 ; i++){
           for( int j = 0 ; j < i ; j++ ){
               if( dp[j] && wordDict.contains(s.substring(j,i))){
                   dp[i] = true;
               }
           }  
           
        }
        return dp[len];
    }
}

//Follow-Up - Find Min Break Time : DFS
public class Solution {
    public int wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return 0;
        return helper(s, wordDict, new HashMap<>());
    }

    public int helper(String s, List<String> wordDict, Map<String,Integer> map) {
        if (s.isEmpty()) return 0;
        if (map.containsKey(s)) return map.get(s);

        int res = Integer.MAX_VALUE;
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                int cur = helper(s.substring(word.length()), wordDict, map) + 1;
                res = Math.min(res, cur);
            }
        }
        map.put(s,res);
        return res;
    }
}

//Follow-Up - Find Min Break Time : DP
public class Solution {
    public int wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        int[] dp = new int[len+1];
        Arrays.fill(dp, Integer.MAX_VALUE );
        dp[0] = 0;
        for( int i = 1 ; i < len + 1 ; i++){
            for( int j = 0 ; j < i ; j++ ){
                if( dp[j]!= Integer.MAX_VALUE && wordDict.contains(s.substring(j,i))){
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }

        }
        return dp[len];
    }
}