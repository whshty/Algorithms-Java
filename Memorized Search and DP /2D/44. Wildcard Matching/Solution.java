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