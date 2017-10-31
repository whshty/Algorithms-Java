import java.util.*;


class Solution {
    public static void main (String[] args) {
        String s = "abbbbbbbbecccddddddddddddf";
        String res = scanStir(s);
        System.out.println(res);
        res = runLenEncoding(s);
        System.out.println(res);

    }
    public static String scanStir(String s){
        if( s == null || s.length() == 0 ) return s;
        char pre = s.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for( int i = 1 ; i < s.length() ; i++ ){
            char cur = s.charAt(i);
            if( pre == cur) count++;
            else{
                sb.append(count).append(pre);
                pre = cur;
                count = 1;
            }
        }
        sb.append(count).append(pre);
        return sb.toString();
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