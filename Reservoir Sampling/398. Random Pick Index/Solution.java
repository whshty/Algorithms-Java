public class Solution {
    int[] nums;
    Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    public int pick(int target) {
        // record how many targets in the array
        int count = 1; 
        int res = -1;
        for(int i = 0 ; i < nums.length ; i++ ){
            if( nums[i] != target ) continue;
            // for the nth target, ++ total is n, then the probability that
            // rand.nextInt(++total) == 0 is 1/n. return nth target is 1/n
            // for (n-1) target, the probability of returning is (n-1)/n * 1/(n-1) = 1/n
            // nextInt(n) = [0,n)
            else if ( rand.nextInt(count++) == 0 ) res = i;
        }
        return res;
    }
}