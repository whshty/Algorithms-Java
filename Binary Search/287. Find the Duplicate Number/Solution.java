class Solution {
    public int findDuplicate(int[] nums) {
        int start = 0 , end = nums.length;
        while( start <= end ){
            int mid = ( start + end ) >>> 1;
            int count = 0;
            for( int i : nums){
                if( i <= mid ) count++;
            }
            if( count <= mid ) start = mid + 1;
            else end = mid - 1;
        } 
        return start;
    }
}