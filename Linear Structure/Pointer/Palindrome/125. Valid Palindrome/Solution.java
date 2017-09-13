public class Solution {
    public boolean isPalindrome(String s) {
        if( s.isEmpty() ) return true;
        int start = 0, end = s.length() -1;
        char left, right;
        while(start <= end){
            left = s.charAt(start);
            right = s.charAt(end);
            if(!Character.isLetterOrDigit(left)) start++;
            else if(!Character.isLetterOrDigit(right)) end--;
            else {
                if (Character.toLowerCase(left) != Character.toLowerCase(right)) return false;
                start++;
                end--;
            }
        }
        return true;
    }
}

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        System.out.println(isPalindrome("cabeebac",0));
    }
    
    public static boolean isPalindrome(String s, int count) {
        if( s.isEmpty() ) return true;
        int start = 0, end = s.length() -1;
        
        char left, right;
        while(start <= end){
            left = s.charAt(start);
            right = s.charAt(end);

                
            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                if( count == 1 )return false;
                return isPalindrome(s.substring(start+1,end+1),1) || isPalindrome(s.substring(start,end),1);
            }
            start++;
            end--;
            
        }
        return true;
    }
}
