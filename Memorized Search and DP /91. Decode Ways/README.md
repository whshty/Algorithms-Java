
### DFS O(2^n)

```java
class Solution {
    public int numDecodings(String s) {
        if( s.length() == 0 ) return 0;
        return helper(s,0);
    }
    public int helper(String s, int index){
        int len = s.length();
        if( index == len ) return 1;
        if(s.charAt(index) == '0') return 0;
        int res = helper(s,index+1);
        if( index < len - 1 && ( s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index+1) < '7'))){
            res += helper(s,index+2);
        }
        return res;
    }
}
```


### Memoization DFS 
* O(2^n) worst case :111111, every digit visit twice 

```java
class Solution {
    public int numDecodings(String s) {
        if( s == null || s.length() == 0 ) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        return helper(s,0,map);
    
    }
    public int helper(String s, int index, Map<Integer,Integer> map){
        if( map.containsKey(index)) return map.get(index);
        if( index == s.length() ) return 1; // see if the recursion can reach the end
        char cur = s.charAt(index);
        if( cur == '0')  return 0;
        int res = 0;
        res += helper(s,index+1,map);
        if( index < s.length() - 1 && ( cur == '1' || (cur == '2' && s.charAt(index+1) < '7'))){
            res += helper(s,index+2,map);
        }
        map.put(index,res);
        return res;
        
    }
}



```



### Dp : Like Fibonacci

* Create a int array to update ways of decoding 
* dp[0] = 1
* Keep checking one digit adn two digit combination
* Give a sample example "12", we have 2 ways od decoding it. Because "1" is between 1 and 9, and 12 is between 10 and 26

```
For exmplple, given string
   1    0     3     8    2     1
-----------------------------------
1  1    1     1     1    1    (1+1)


For exmplple, given string
   1    2     2     2    1     0
-----------------------------------
1  1   2     1+2   2+3   3+5   5

```


```java
public class Solution {
    public int numDecodings(String s) {
        if ( s == null || s.length() == 0 ) return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0:1;
        for( int i = 2 ; i <= n ; i++ ){
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9){
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <=26 ){
                dp[i] += dp[i-2];
            }
            
        }
        return dp[n];
    }
}
```

### Generate all result 

```
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        List<List<String>> dp = new ArrayList<List<String>>();
        for (int i = 0; i < s.length()+1; i++) dp.add(new ArrayList<String>());
        dp.get(0).add("");
        dp.get(1).add(""+(char)('A'+(s.charAt(0)-'0')));
        for (int i = 2; i < dp.size(); i++) {
            int a = s.charAt(i-1) - '0';
            int b = (s.charAt(i-2)-'0') * 10 + a;
            if (a != 0) {
                char c = (char)('A' + a);
                for (String ss : dp.get(i-1)) {
                    dp.get(i).add(ss+c);
                }
            }
            if (b >= 10 && b <=26) {
                char c = (char)('A' + b);
                for (String ss : dp.get(i-2)) {
                    dp.get(i).add(ss+c);
                }
            }
        }
        return dp.get(s.length()).size();
    }
}

```