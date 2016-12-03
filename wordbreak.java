// time : each word search can stop at the max length of the dictionary words, 
//        which could be taken as much smaller than the string size. So it's not O(n^2), but O(n*wlen).
// space : o(n)
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] f = new boolean[len+1];
        f[0] = true;
        for(int i=1 ; i < len + 1 ; i++){
            for( int j = 0 ; j < i ; j++ ){
                if( f[j] && wordDict.contains(s.substring(j,i))) f[i] = true;
            }
        }
        return f[len];
        
    }
}