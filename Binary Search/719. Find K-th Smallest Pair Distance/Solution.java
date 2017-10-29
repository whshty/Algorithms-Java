class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        
        int start = nums[1] - nums[0];
        for( int i = 1 ; i < len - 1 ; i++ ) start = Math.min(start,nums[i+1] - nums[i]);
        int end = nums[len - 1] - nums[0];
        while( start < end ) {
            int mid = ( start + end ) >>> 1;
            if( countPairs(nums,mid) < k )  start = mid + 1;
            else end = mid;
        }        
        return start;   
    }
    public int countPairs( int[] nums , int mid ) {
        int len = nums.length, res = 0;
        for (int left = 0; left < len; left++) {
            int right = left;
            while (right < len && nums[right] - nums[left] <= mid) right++;
            res += right - left - 1;
        }
        return res;
    }
}