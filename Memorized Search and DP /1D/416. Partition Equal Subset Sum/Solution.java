// Memo DFS
public class Solution {
    public boolean canPartition(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for( int num : nums ){
            map.put(num,map.getOrDefault(num,0)+1);
            sum += num;
        }
        if( sum % 2 != 0 ) return false;
        
        return dfs(map,sum/2);    
    }
    
    private boolean dfs(Map<Integer,Integer> map, int target){
        if(map.containsKey(target) && map.get(target) > 0 ) return true;
        
        for( int key : map.keySet()){
            if( key < target && map.get(key) > 0 ){
                map.put(key,map.get(key)-1);
                if(dfs(map,target-key)) return true;
                map.put(key,map.get(key)+1);
            }
        }
        return false;   
    }
}

// DP - 2D 
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
    
        for (int num : nums) {
            sum += num;
        }
        // If even than false
        if ((sum & 1) == 1) return false;
        sum /= 2;

        int len = nums.length;
        boolean[][] dp = new boolean[len+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }
    
        dp[0][0] = true;
        
        // sum = 0 in ith
        for (int i = 1; i < len + 1; i++) {
            dp[i][0] = true;
        }
        // sum = j in 0th 
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = false;
        }
    
        for (int i = 1; i < len + 1 ; i++) {
            for (int j = 1; j < sum + 1 ; j++) {
                dp[i][j] = dp[i-1][j];
                if ( j >= nums[i-1] ) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }
        return dp[len][sum];
    }
}

// DP - 1D
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
    
        for (int num : nums) {
            sum += num;
        }
        // If even than false
        if ((sum & 1) == 1) return false;
        sum /= 2;

        int len = nums.length;
        boolean[] dp = new boolean[sum+1];
        Arrays.fill(dp,false);
        dp[0] = true;
        
        for( int num : nums ){
            for( int i = sum ; i > 0 ; i-- ){
                if( i >= num){
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }
        return dp[sum];
    }
}



