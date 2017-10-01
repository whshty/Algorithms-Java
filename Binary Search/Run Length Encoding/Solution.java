import java.util.*;

class Solution {
    public static void main (String[] args) {
        String s = "abbbbbbbbecccddddddddddddf";
        String res = runLenEncoding(s);
        System.out.println(res);
        
    }
    public static String runLenEncoding(String s){
        int start  = 0;
        StringBuilder sb = new StringBuilder();
        while( start < s.length() ){
            char temp = s.charAt(start);
            int end = binarySearch(s,temp,start,s.length()-1);
            sb.append(end - start +1 );
            sb.append(temp);
            start = end + 1;
        }

        return sb.toString();
    }
    
    public static int binarySearch(String s, char c, int start, int end){
        while( start < end ){
            int mid = ( start + end ) >>> 1;
            if( mid + 1 <= end && s.charAt(mid) == c && s.charAt(mid+1) != c) return mid;
            
            if( s.charAt(mid) == c ){
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return start;        
    }
}
