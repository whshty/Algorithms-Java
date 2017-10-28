// Search
class Solution {    
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int[] res = new int[1];
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            isPalindrome(s , res, i, i); 
            isPalindrome(s , res, i, i + 1);
        }
        
        return res[0];
    }
    
    private void isPalindrome(String s, int[] res , int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            res[0]++; 
            start--;
            end++;
        }
    }
}

//DP
class Solution {    
    public int countSubstrings(String s) {
        int len = s.length();
       
        boolean[][] dp = new boolean[len][len];
        for( int i = 0 ; i < len ; i++ ){
            dp[i][i] = true;
        }
        int res = len;
    
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1 ; j < len; j++) {
                if( s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]) ){
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}


