class Solution {
    public String shortestPalindrome(String s) {
        int start = 0;
        
        for (int end = s.length() - 1 ; end >= 0 ; end--) {
            if ( s.charAt(start) == s.charAt(i) ) start += 1; 
        }
        
        if (start == s.length()) return s; 
        
        String sub = s.substring(start);
        return new StringBuilder(sub).reverse().toString() + shortestPalindrome(s.substring(0, start)) + sub;
    }
}