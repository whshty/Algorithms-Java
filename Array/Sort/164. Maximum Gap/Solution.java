public class Solution {
    public int maximumGap(int[] nums) {
        if( nums == null || nums.length < 2 ) return 0;
        if( nums.length == 2 ) return Math.abs(nums[0]-nums[1]);
        int min = nums[0];
        int max = nums[0];
        for( int i : nums ){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        
        //int gap = (int)Math.ceil((double)(max - min)/(nums.length - 1));
        int gap = ( max - min - 1 ) / ( nums.length - 1 ) + 1 ;
        int[] minBucket = new int[nums.length-1];
        int[] maxBucket = new int[nums.length-1];
        
        Arrays.fill(minBucket,Integer.MAX_VALUE);
        Arrays.fill(maxBucket,Integer.MIN_VALUE);
        
        for ( int i : nums ){
            if( i == min || i == max ) continue;
            int index = ( i - min ) / gap;
            minBucket[index] = Math.min(i,minBucket[index]);
            maxBucket[index] = Math.max(i,maxBucket[index]);
        }
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for( int i = 0 ; i  < nums.length - 1 ; i++ ){
            if( minBucket[i] == Integer.MAX_VALUE && maxBucket[i] == Integer.MIN_VALUE) continue;
            maxGap = Math.max(maxGap,minBucket[i] - previous);
            previous = maxBucket[i];
        }
        maxGap = Math.max(maxGap, max - previous); 
        return maxGap;
    }
}