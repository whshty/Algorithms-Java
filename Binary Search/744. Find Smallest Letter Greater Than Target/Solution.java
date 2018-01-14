class Solution {
    public char nextGreatestLetter(char[] chars, char target) {
        int len = chars.length;
        int start = 0 , end = len;

        while( start < end ){
            int mid = ( start + end ) >>> 1;
            if( chars[mid] > target ) end = mid;
            else start = mid + 1;
        }
        return chars[end%len];
    }
}
