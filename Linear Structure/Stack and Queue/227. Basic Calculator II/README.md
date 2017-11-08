```java
class Solution {
    public int calculate(String s) {
        if( s == null || s.length() == 0 ) return 0;
        int cur = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        char sign = '+';
        int len = s.length();
        for( int i = 0 ; i < len ; i++ ){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) cur = cur * 10 + ch - '0';
            
            if((!Character.isDigit(ch) && ' ' != ch ) || i == len - 1){
                if(sign == '-') deque.addLast(cur * -1);
                if(sign == '+') deque.addLast(cur);
            
                if(sign=='*') deque.addLast(deque.removeLast()*cur);
                if(sign=='/') deque.addLast(deque.removeLast()/cur);
                sign = ch;
                cur = 0;
            }
        }
        int res = 0;
        for( int i : deque ) res += i;
        return res;
        
    }
}
```