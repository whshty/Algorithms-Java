Typical solution of calculating subarray sum. Using slidng window

```
class myCode {
    public static void main (String[] args) throws java.lang.Exception {        
        int[] nums = new int[]{2,3,1,5,8};
        System.out.println(subArraySum(nums,18));    
    }
    
    public static boolean subArraySum(int[] nums, int k){
        if( nums == null || nums.length == 0 ) return false;
        int start = 0 , end = 0 , sum = 0;
        
        while( end < nums.length ){
            sum += nums[end++];
            if( sum == k ) {
                return true;
            }
            while( sum > k ){
                sum -= nums[start];
                start++;
            }
        }
        return false;
    }
}

```