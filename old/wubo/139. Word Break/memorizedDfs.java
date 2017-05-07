public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s,wordDict, new HashSet<Integer>() , 0 );
    }
    public boolean dfs(String s, List<String> dict, Set<Integer> set, int pos){
        if( pos == s.length() ) return true;
        if( set.contains(pos) ) return false;
        
        for( int i = pos + 1; i <= s.length() ; i++ ){
            String str = s.substring(pos,i);
            if( dict.contains(str)){
                if( dfs(s,dict,set,i)){
                    return true;
                } else{
                    set.add(i);
                }
            }
            set.add(pos);
        }
        return false;
    }
}