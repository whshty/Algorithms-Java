public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if( nums == null || nums.length == 0 ) return false;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1);
        int preSum = 0;
        for( int i = 0 ; i < nums.length ; i++ ){
            preSum += nums[i];
            if( k != 0 ) {
                preSum %= k;
            }
            Integer pre = map.get(preSum);
            if( pre != null ){
                if( i - pre > 1 ) return true;
            }
            else map.put(preSum,i);
        }
        return false;
    }
}