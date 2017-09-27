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