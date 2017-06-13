public class Solution {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for( int num : nums ){
            max = Math.max(max,num);
            sum += num;
        }
        return (int)binarySearch(nums,m,max,sum);
    
    }
    
    private long binarySearch(int[] nums, int m, long low, long high){
        long mid = 0;
        while( low < high ){
            mid = ( low + high ) >>> 1; 
            if( isValid(nums,m,mid)){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
    
    private boolean isValid(int[] nums, int m, long max){
        int cur = 0;
        int count = 1;
        for( int num : nums ){
            cur += num;
            if( cur > max ){
                cur = num;
                count++;
                if( count > m ){
                    return false;
                }
            }
        }
        return true;
    }
}