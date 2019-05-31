## 1.Brute force

```java
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return new ArrayList<>();
        return helper(s,wordDict);
    }
    public List<String> helper(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if( word.length() == s.length() ){
                    res.add(word);
                    continue;
                } else {
                    List<String> strs = helper(s.substring(word.length()), wordDict);
                    for( String str : strs ){
                        StringBuilder sb = new StringBuilder();
                        sb.append(word).append(" ").append(str);
                        res.add(sb.toString());
                    }
                }
            }
        }
        return res;
    }
}
```


## 2.Memo DFS
* Time: O(2^n)
* Space: O(n)

```java
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if( s.length() == 0 ) return new ArrayList<>();
        return helper(s,wordDict, new HashMap<>());
    }
    public List<String> helper(String s, List<String> wordDict, HashMap<String, List<String>> map){
        if( map.containsKey(s)) return map.get(s);

        List<String> res = new ArrayList<>();
        for( String word : wordDict ){
            if( s.startsWith(word)){
                if( word.length() == s.length() ){
                    res.add(word);
                    continue;
                } else {
                    List<String> strs = helper(s.substring(word.length()),wordDict,map);
                    for( String str : strs ){
                        StringBuilder sb = new StringBuilder();
                        sb.append(word).append(" ").append(str);
                        res.add(sb.toString());
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
```
