### BFS
* Create a string array for keyboard and check it by number 
* Create a list of strng to save res
* For every digit, add new characters from the keyborad to old string and add these to res
* O(3~4)^n : For every number has 3 or 4 characters to be generated 

```java
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if ( digits == null || digits.length() == 0 ) return res;
        res.add("");
        String[] keys = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] nums = digits.toCharArray();
        for(int i = 0 ;i < nums.length ; i++){
            int num = nums[i] - '0';
            List<String> list = new ArrayList<>();
            String cur = keys[num];
            for( int j = 0 ; j < cur.length(); j++ ){
                for( String str : res ){
                    list.add(str + cur.charAt(j));
                }
            }
            res = list;
        }
        return res;
    }
}
```

### DFS

```java
public class Solution {
    private static final String[] keys = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if( digits == null || digits.length() == 0 ) return res;
        StringBuilder sb = new StringBuilder();
        dfs(sb,digits,0,res);
        return res;
    }
    private void dfs(StringBuilder sb, String digits, int pos , List<String> res){
        if( sb.length() >= digits.length()){
            res.add(sb.toString());
            return;
        }
        String s = keys[digits.charAt(pos) - '0'];
        int len = sb.length();
        for( int i = 0 ; i < s.length(); i++ ){
            dfs(sb.append(s.charAt(i)), digits, pos + 1 , res );
            sb.setLength(len);
        }
    }
}
```