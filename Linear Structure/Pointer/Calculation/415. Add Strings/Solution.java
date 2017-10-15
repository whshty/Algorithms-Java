public class Solution {
    public String addStrings(String num1, String num2) {
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while( i >= 0 || j >= 0 || carry == 1 ){
            int a = i >= 0 ? (ch1[i--] - '0') : 0;
            int b = j >= 0 ? (ch2[j--] - '0') : 0;
            
            int sum = a + b + carry;
            sb.append(sum%10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}