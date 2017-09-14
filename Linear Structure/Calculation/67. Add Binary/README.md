* Count from end to start, then reverse
* Use carry to mark the extra value of the next position

```
public class Solution {
    public String addBinary(String a, String b) {
        if( a == null || a.length() == 0 ) return b;
        if( b == null || b.length() == 0 ) return a;
        
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1; 
        StringBuilder sb = new StringBuilder();
        
        while( i >= 0 || j >= 0 ) {
            int sum = 0;
            int val;
            sum += carry;
            if( i >= 0 ) sum += a.charAt(i) - '0';
            if( j >= 0 ) sum += b.charAt(j) - '0';
            
            val = sum % 2 ;
            sb.append(val);
            carry = sum / 2;
            i--;
            j--;
        }
        if( carry != 0 ) sb.append(carry);
        return sb.reverse().toString();
    }
}

```
### Follow - Up (Add Decimal)

```
import java.io.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        String res = addDecimal("1","19");
        System.out.println(res);
    }
    public static String addDecimal(String a , String b){
        if( a == null || a.length() == 0 ) return b;
        if( b == null || b.length() == 0 ) return a;
        int carry = 0 ;
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        StringBuilder sb = new StringBuilder();
        
        while( i >= 0 || j >= 0 ){
            int sum = 0;
            int val;
            sum += carry;
            if( i >= 0 ) sum += a.charAt(i) - '0'; 
            if( j >= 0 ) sum += b.charAt(j) - '0';
            val = sum % 10;
            sb.append(val);
            carry = sum / 10;
            i--;
            j--;
        }
        if( carry != 0 ) sb.append(carry);
        return sb.reverse().toString(); 
    }
}

```

