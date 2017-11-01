class Solution {
    public boolean validPalindrome(String s) {
        return helper(s,0);
    }
    public boolean helper(String s, int count){
        if( s.isEmpty()) return true;
        int start = 0 , end = s.length() -1;
        char left , right;
        while( start <= end ){
            left = s.charAt(start);
            right = s.charAt(end);
            
            if( left != right ){
                if( count == 1 ) return false;
                else {
                    count = 1;
                    return helper(s.substring(start+1,end+1),1) || helper(s.substring(start,end),1); 
                }
            }
            start++;
            end--;
        }
        return true;
    }
}

class Solution {
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while( start  <  end ){
            if( s.charAt(start) != s.charAt(end)){
                // delete start || delete end
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isPalindrome(String s , int start , int end){
        while( start < end){
            if( s.charAt(start) != s.charAt(end)) return false;
            start++; 
            end--;
       }
      return true;
    }
}