class Solution {
    public int longestSubstring(String s, int count) {
        char[] str = s.toCharArray();
        int[] freq = new int[26];
        int res = 0;

        for (int i = 1; i <= 26; i++) {
            Arrays.fill(freq, 0);
            int j = 0;
            int k = 0;
            int uniqueCount = 0;
            int noLessThanK = 0;
            int index = 0;
            while (index < str.length) {
                if (uniqueCount <= i) {
                    int ch = str[j] - 'a';
                    if (freq[ch] == 0) uniqueCount++;
                    freq[ch]++;
                    if (freq[ch] == count) noLessThanK++;
                    j++;
                } else {
                    int ch = str[k] - 'a';
                    if (freq[ch] == count) noLessThanK--;
                    freq[ch]--;
                    if (freq[ch] == 0) uniqueCount--;
                    k++;
                }
                if (uniqueCount == i && uniqueCount == noLessThanK) res = Math.max(j - k, res);
            }
        }
        return res;
    }
}