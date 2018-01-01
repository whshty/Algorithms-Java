class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for( int i = 1 ; i < nums.length ; i++){
            if( count > 1 ) return false;
            if( nums[i] < nums[i-1]){
                count++;
                // When you find nums[i-1] > nums[i] for some i, you will prefer to change nums[i-1]'s value,
                // since a larger nums[i] will give you more risks that you get inversion errors after position i
                if( i - 2 < 0 || nums[i-2] <= nums[i]) nums[i-1] = nums[i];
                // , if you also find nums[i-2] > nums[i], then you have to change nums[i]'s value instead
                // or else you need to change both of nums[i-2]'s and nums[i-1]'s values.
                else nums[i] = nums[i-1];
            }
        }
        return count <= 1;
    }
}