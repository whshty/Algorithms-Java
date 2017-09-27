class Solution {
    public boolean search(int[] nums, int target) {
        if( nums == null || nums.length == 0 ) return false;
        int start = 0, end = nums.length -1, mid;
        
        while( start <= end ){
            mid = ( start + end ) >>> 1;
            if( nums[mid] == target ) return true;
            
            //If we know for sure left side is sorted or right side is unsorted
            if( nums[mid] > nums[end] || nums[mid] > nums[start] ){
                if( target < nums[mid] && target >= nums[start]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            //If we know for sure right side is sorted or left side is unsorted

            // eg. 5,6,1,2,3,4
            else if (nums[mid] < nums[end] || nums[mid] < nums[end]) {
                if( target > nums[mid] && target <= nums[end] ) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
                //any of the two sides won't change the result but can help remove duplicate from
                //consideration, here we just use end-- but left++ works too
                end--;
            }
            
        }
        return false;
    }
}