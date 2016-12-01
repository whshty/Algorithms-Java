/*
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
// dfs





// bfs
// round 1 : ""
// round 2 : a,b,c
// round 3 : ad , ae , af , bd , be , bf , cd , ce , cf 
public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.length() == 0) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i=0;i<digits.length();i++){
            int  x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length() == i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray()) ans.add(t+s);
            }
        }
        return ans;
    }
}