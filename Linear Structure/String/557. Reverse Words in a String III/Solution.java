class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        for( int i = 0 ; i < strs.length ; i++ ) {
            strs[i] = new StringBuilder(strs[i]).reverse().toString();
        }
        StringBuilder sb = new StringBuilder();
        for( String str : strs ){
            sb.append(str).append(" ");
        }
        return sb.toString().trim();
    }
}