## 1.1.DFS
* Worst case : O(n^2)

```java
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
```


## 1.2.DP
* dp[i] is true if ther a word in the dictionary that end at ith of s adnd is also true at the beginning of the word
* Time  : O(n^2)

```
s = "facebook"
words = ["face" , "book"]
dp
0 1 2 3 4 5 6 7 8 
t       t       t   
  f a c e 
         b o o k 
```




```java
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
```

## 2.1 Follow-Up - Find Min Break Time : DFS

```java
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

```

