class Solution {
    public int[] shortestToChar(String input, char ch) {
        int len = input.length();
        int[] res = new int[len];
        int pos = -len;
        for (int i = 0 ; i < len ; i++) {
            if (input.charAt(i) == ch) pos = i;
            res[i] = i - pos;
        }
        for (int i = len - 1 ; i >= 0 ; i--) {
            if (input.charAt(i) == ch) pos = i;
            res[i] = Math.min(res[i],Math.abs(i-pos));
        } 
        return res;
    }
}