### DFS
* Worst case : O(n^2)

```java
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
```


### DP

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

dp[i] is true if ther a word in the dictionary that end at ith of s adnd is also true at the beginning of the word


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

