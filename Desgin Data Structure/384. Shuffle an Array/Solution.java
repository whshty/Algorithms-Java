class Solution {
    private int[] nums;
    private Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if( nums == null || nums.length == 0 ) return null;
        int[] clone = nums.clone();
        for( int i = 1 ; i < nums.length ; i++ ){
            int j = rand.nextInt(i+1);
            swap(clone,j,i);
        }
        return clone;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}