public class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        StringBuilder pre = new StringBuilder();
        for( int i = 1 ; i <  n ; i++ ){
            pre = sb;
            sb = new StringBuilder();
            int count = 1;
            char val = pre.charAt(0);
            
            for( int  j = 1 ; j < pre.length(); j++){
                if( pre.charAt(j) != val){
                    sb.append(count).append(val);
                    count  = 1;
                    val = pre.charAt(j);
                } else count++;
            }
            sb.append(count).append(val);
        }
        return sb.toString();
    }
}