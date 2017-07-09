public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if( nums == null || nums.length == 0 || target <= 0 ){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        dfs(nums,map,target);
        return map.get(target);
        
    }
    
    private int dfs(int[] nums, Map<Integer,Integer> map, int sum ){
        if( sum < 0 ){
            return 0;
        }
        if( map.containsKey(sum)){
            return map.get(sum);
        }
        
        int res = 0;
        for( int i = 0 ; i < nums.length ; i++ ){
            sum -= nums[i];
            if(map.containsKey(sum)){
                res += map.get(sum);
            } else {
                res += dfs(nums,map,sum);
            }
            sum += nums[i];
        }
        map.put(sum,res);
        return map.get(sum);
        
    }
}