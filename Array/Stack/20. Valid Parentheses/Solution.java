public class Solution {
    public boolean isValid(String s) {
        if( s == null ) return true;
        Deque<Character> deque = new ArrayDeque<>();
        for( char c : s.toCharArray()){
            if( c == '('){
                deque.addLast(')');
            } else if ( c == '{'){
                deque.addLast('}');
            } else if ( c == '['){
                deque.addLast(']');
            } else if ( deque.isEmpty() || deque.pollLast() != c ){
                return false;
            }
        }
        return deque.isEmpty();
    }
}