public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        int cur = 0;
        int sign = 1;
    
        for( int i = 0 ; i < s.length(); i++ ){
            char ch = s.charAt(i);
            if( Character.isDigit(ch)){
                cur = 10 * cur + (int)( ch - '0');
            } else if( ch == '+'){
                res += sign * cur;
                cur = 0;
                sign = 1;
            } else if( ch == '-'){
                res += sign * cur;
                cur = 0;
                sign = -1;
            } else if( ch == '(' ){
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
                cur = 0;
            } else if( ch == ')'){
                res += sign * cur;
                cur = 0;
                res *= stack.pop();
                res += stack.pop();
            }
            
        }
        if( cur != 0 ) res += sign * cur;
        return res;
    }
}