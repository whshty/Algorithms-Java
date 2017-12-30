public class Solution {
    public int longestSubstring(String s, int count) {
        char[] str = s.toCharArray();
        int[] freq = new int[26];
        int res = 0;

        for (int i = 1; i <= 26; i++) {
            Arrays.fill(freq, 0);
            int left = 0;
            int right = 0;
            int uniqueCount = 0;
            int noLessThanK = 0;
            while (right < str.length) {
                if (uniqueCount <= i) {
                    int ch = str[right] - 'a';
                    if (freq[ch] == 0) uniqueCount++;
                    freq[ch]++;
                    if (freq[ch] == count) noLessThanK++;
                    right++;
                }
                else {
                    int ch = str[left] - 'a';
                    if (freq[ch] == count) noLessThanK--;
                    freq[ch]--;
                    if (freq[ch] == 0) uniqueCount--;
                    left++;
                }
                if (uniqueCount == i && uniqueCount == noLessThanK) res = Math.max(right - left, res);
            }
        }
        return res;
    }
}