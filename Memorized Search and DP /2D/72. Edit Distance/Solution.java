// dp[i][j] to represent the shortest edit distance between word1[0,i) and word2[0,j)
// then compare the character of word1[i] and word2[j], which are c and d respectively (c == word1[i-1], d == word2[j-1])
// if c == d, dp[i][j] = dp[i-1][j-1]
// otherwise, we have three options
// replace c with d , dp[i][j] = dp[i-1][i-j] + 1
// add d after c, dp[i][j] = dp[i][j-1] + 1
// delete c, dp[i][j] = dp[i-1][j] + 1 
public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        // dp[i][j] indicate the min operation from matching word1[0 ~ i-1] and word2[0 ~ j-1] 
        for( int j = 1 ; j < word2.length() +1  ; j++){
            dp[0][j] = j;
        }
        for( int i =  1 ; i < word1.length() + 1 ; i++ ){
            dp[i][0] = i;
            for( int j = 1 ; j < word2.length() + 1 ; j++ ){
                if( word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}