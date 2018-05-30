// DFS
public class Solution {
    public int minDistance(String word1, String word2) {
        return helper(word1, word2, 0, 0,new HashMap<>());
    }

    private int helper(String word1, String word2, int index1, int index2 , Map<int[],Integer> map) {
        if (index1 == word1.length()) return word2.length() - index2;
        if (index2 == word2.length()) return word1.length() - index1;
        
        int[] pos = new int[]{index1,index2};
        if( map.containsKey(pos)) return map.get(pos);
        
        int res;
        if (word1.charAt(index1) == word2.charAt(index2)) {
            res = helper(word1, word2, index1 + 1, index2 + 1,map);
        } else {
            // replace char
            res = 1 + helper(word1, word2, index1 + 1, index2 + 1,map);
            // delete char from word1
            res = Math.min(res, 1 + helper(word1, word2, index1 + 1, index2,map));
            // delete char from word2
            res = Math.min(res, 1 + helper(word1, word2, index1, index2 + 1,map));
        }
        map.put(pos,res);
        return res;
    }
}


// DP
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < word1.length() + 1; i++) {
            for (int j = 0; j < word2.length() + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}