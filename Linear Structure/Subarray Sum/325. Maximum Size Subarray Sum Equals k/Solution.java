class Solution {
    public int maxSubArrayLen(int[] nums, int target) {
        int res = 0;
        if( nums == null || nums.length == 0 ) return res;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        
        for( int i = 0 ; i < nums.length ; i++ ){
            sum += nums[i];
            map.putIfAbsent(sum,i);
            if(map.containsKey(sum-target)){
                res = Math.max(res,i-map.get(sum-target));
            }
        }
        return res;
    }
}