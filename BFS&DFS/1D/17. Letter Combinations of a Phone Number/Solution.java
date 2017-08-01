public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if( digits.length() == 0 ) return res;
        String[] keys = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(keys,res,new StringBuilder(),digits.toCharArray(),0);
        return res;
    }
    
    private void dfs(String[] keys, List<String> res, StringBuilder sb , char[] digits, int pos){
        if( pos == digits.length ){
            res.add(sb.toString());
            return;
        }
        
        String cur = keys[digits[pos] - '0'];
        
        for( int i = 0 ; i < cur.length() ; i++ ){
            StringBuilder temp = new StringBuilder(sb);
            temp.append(cur.charAt(i));
            dfs(keys,res,new StringBuilder(temp),digits,pos+1);
        }
    }
}