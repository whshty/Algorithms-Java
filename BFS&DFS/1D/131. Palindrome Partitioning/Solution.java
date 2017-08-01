public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if( s == null || s.length() == 0 ) return res;
        dfs(s,res,new ArrayList<>(),0);
        return res;
        
    }
    private void dfs(String s, List<List<String>> res, List<String> list, int pos){
        if(  pos == s.length() ){
            res.add(new ArrayList<>(list));
            return;
        }
        for( int i = pos ; i < s.length() ; i++ ){
            if( isPalindrome(s,pos,i) ){
                list.add(s.substring(pos,i+1));
                dfs(s,res,list,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int left, int right){
        if ( s.length() == 1 ) return true;
        while( left < right){
            if( s.charAt(left) == s.charAt(right) ){
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;        
    }
}