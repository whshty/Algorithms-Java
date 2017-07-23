public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if( nums == null || nums.length == 0 ) return false;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        for( int i = 0 ; i < nums.length ; i++ ){
            sum += nums[i];
            if( k != 0 ) sum %= k;
            Integer prePos = map.get(sum);
            if( prePos != null ){
                if(i - prePos > 1 ) return true;
            }
            else map.put(sum,i);
        }
        return false;
    }
}