## DFS
* Time : O(2^n)

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), 0 , 0 , n);
        return res;
    }
    public void helper( List<String> res , StringBuilder sb, int left, int right , int max ){
        if( sb.length() ==  max*2 ){
            res.add(sb.toString());
            return;
        }
        if( left < max ){
            int len = sb.length();
            helper(res, sb.append('(') , left + 1 , right , max);
            sb.setLength(len);
        }
        if( right < left){
            int len = sb.length();
            helper(res, sb.append(')') , left , right + 1 , max);
            sb.setLength(len);
        }
    }
}
```
