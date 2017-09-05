public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if( nums == null || nums.length == 0 || target <= 0 ) return 0;
        return helper(nums,target);
    }
    
    private int helper(int[] nums, int sum ){
        if( sum < 0 ) return 0;
        if( sum == 0 ) return 1;
        
        int res = 0;
        for( int i = 0 ; i < nums.length ; i++ ){
            res += helper(nums,sum-nums[i]);
        }
        return res;
    }
}

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if( nums == null || nums.length == 0 || target <= 0 ){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        helper(nums,map,target);
        return map.get(target);
    }
    
    private int helper(int[] nums, Map<Integer,Integer> map, int sum ){
        if( sum < 0 ) return 0;
        if( sum == 0 ) return 1;
        if( map.containsKey(sum)) return map.get(sum);
        
        int res = 0;
        for( int i = 0 ; i < nums.length ; i++ ){
            if(map.containsKey(sum)) res += map.get(sum);
            else res += helper(nums,map,sum - nums[i]);
        }
        map.put(sum,res);
        return map.get(sum);  
    }
}