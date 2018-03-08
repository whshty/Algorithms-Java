class Solution {
    public List<String> letterCasePermutation(String s) {
        if (s == null) return new LinkedList<>();
        
        List<String> res = new LinkedList<>();
        dfs(s, res, 0);
        return res;
    }
    
    public void dfs(String s, List<String> res, int pos) {
        if (pos == s.length()) {
            res.add(s);
            return;
        }
        if (s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
            dfs(s, res, pos + 1);
            return;
        }
        
        char[] chs = s.toCharArray();
        chs[pos] = Character.toLowerCase(chs[pos]);
        dfs(String.valueOf(chs), res, pos + 1);
        
        chs[pos] = Character.toUpperCase(chs[pos]);
        dfs(String.valueOf(chs), res, pos + 1);
    }
}