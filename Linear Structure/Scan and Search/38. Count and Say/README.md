```
public class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        StringBuilder pre = new StringBuilder();
        for( int i = 1 ; i <  n ; i++ ){
            pre = sb;
            sb = getNextSb(pre);
        }
        return sb.toString();
    }
    public StringBuilder getNextSb(StringBuilder pre){
        StringBuilder sb = new StringBuilder();
        int count =1 ;
        char val = pre.charAt(0);
        
        for( int i = 1 ; i < pre.length(); i++ ){
            if( pre.charAt(i) != val ){
                sb.append(count).append(val);
                count = 1;
                val = pre.charAt(i);
            } else {
                count++;
            }
        }
        sb.append(count).append(val);
        return sb;    
    }
}
```