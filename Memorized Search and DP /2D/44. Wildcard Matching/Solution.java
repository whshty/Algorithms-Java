class Solution {
    public boolean isMatch(String s, String p) {  
        return helper(s, p, 0, 0);  
    }  
      
    public boolean helper(String s, String p, int i, int j){  
        if( j == p.length()) return i == s.length();  

        if( p.charAt(j) != '*'){  
            if( i >= s.length() || ( s.charAt(i) != p.charAt(j) && p.charAt(j) != '?'))  return false;  
            else return helper(s, p, i + 1, j + 1);  
        }  
        else{  
            while( i < s.length() ){  
                if(helper(s, p, i, j + 1))  return true;  
                i++;  
            }  
        }  
        return helper(s, p, i, j + 1);  
    }  
}

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[s.length()][p.length()] = true;
        for(int i = p.length() - 1 ; i >= 0 ; i--){
            if( p.charAt(i) != '*') break;
            else dp[s.length()][i]=true;
        }
        
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            for(int j = p.length() - 1 ; j >= 0 ; j--){
                if( s.charAt(i) == p.charAt(j) || p.charAt(j)=='?') dp[i][j] = dp[i+1][j+1];
                else if( p.charAt(j) == '*' ) dp[i][j] = dp[i+1][j]||dp[i][j+1];
                else dp[i][j]=false;
            }
        }
        return dp[0][0];
    }
}