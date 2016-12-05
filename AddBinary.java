public class Solution {
    public String addBinary(String a, String b) {
        if(a==null||a.length()==0) return b;
        if(b==null||b.length()==0) return a;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        String str = "";
        while(i>=0||j>=0){
            if(i >= 0) carry += a.charAt(i--) - '0';
            if(j >= 0) carry += b.charAt(j--) - '0';
            int pos = carry % 2;
            str += pos;
            carry = carry/2;
        }
        if(carry != 0) str += carry;
        return new StringBuilder(str).reverse().toString();
    }
}