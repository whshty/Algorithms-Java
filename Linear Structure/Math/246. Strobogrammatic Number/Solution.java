public class Solution {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('0','0');
        map.put('1','1');
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');
        for( int i = 0 ; i < num.length(); i++){
            int start = 0;
            int end = num.length() - 1;
            while (start <= end ){
                if (map.get(num.charAt(start)) == null || map.get(num.charAt(start)) != num.charAt(end) ) return false;
                start++;
                end--;
            }
        }
        return true;
        
    }
}