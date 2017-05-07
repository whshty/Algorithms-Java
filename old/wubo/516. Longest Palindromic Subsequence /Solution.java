// brute force
public class Solution {
    public int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseq(s,0,s.length()-1);
    }
    public int longestPalindromeSubseq(String s, int left , int right){
        if( left == right ) return 1;
        if( left > right ) return 0;
        if( s.charAt(left) == s.charAt(right) ){
            return 2 + longestPalindromeSubseq(s,left+1,right-1);
        } else{
            return Math.max(longestPalindromeSubseq(s,left+1,right),longestPalindromeSubseq(s,left,right-1));
        }
    } 
}
// memorized search
public class Solution {
    public int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseq(s,0,s.length()-1, new int[s.length()][s.length()]);
    }
    public int longestPalindromeSubseq(String s , int left, int right, int[][] cache){
        if( cache[left][right] != 0 ) {
            return cache[left][right];
        }
        if( left > right ) return 0;
        if( left == right ) return 1;
        if( s.charAt(left) == s.charAt(right) ){
            cache[left][right] = 2 + longestPalindromeSubseq(s,left+1,right-1,cache);
        } else{
            cache[left][right] = Math.max(longestPalindromeSubseq(s,left+1,right,cache),
                                          longestPalindromeSubseq(s,left,right-1,cache));
        }
        return cache[left][right];
    }
}