public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int last = s.lastIndexOf(' ') + 1;
        return s.length() - last;
    }
}