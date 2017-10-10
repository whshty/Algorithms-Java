public class Solution {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = Integer.MIN_VALUE;
        for( int num : nums ){
            max = Math.max(max,num);
            sum += num;
        }
        return (int)binarySearch(nums,m,max,sum);
    
    }
    
    private long binarySearch(int[] nums, int m, long start , long end){
        while( start < end ){
            long mid = ( start + end ) >>> 1; 
            if( isValid(nums,m,mid)){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
    
    private boolean isValid(int[] nums, int m, long max){
        int cur = 0;
        int count = 1;
        for( int num : nums ){
            cur += num;
            if( cur > max ){
                cur = num;
                count++;
                if( count > m ) return false;
            }
        }
        return true;
    }
}