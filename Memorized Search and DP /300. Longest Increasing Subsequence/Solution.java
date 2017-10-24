public class Solution {
    public int lengthOfLIS(int[] n) {
        if(n == null || n.length == 0 ) return 0;
        int[] dp = new int[n.length];
        dp[0] = n[0];
        int len = 0;
        for( int i = 1; i < n.length; i++){
            int pos = binarySearch(dp,len,n[i]);
            if( n[i] < dp[pos]) dp[pos] = n[i];
            if( pos > len){
                len = pos;
                dp[len] = n[i];
            }
        }
        return len+1;
    }
    public int binarySearch(int[] arr, int len, int target){
        int start = 0;
        int end = len;
        while( start + 1 <  end ){
            int mid = ( start + end ) >>> 1;
            if(arr[mid] == target) return mid;
            else{
                if(arr[mid] < target) start = mid;
                else end = mid;
            }
        }
        if( arr[end] < target) return len+1;
        else if (arr[start] >= target) return start;
        else return end;
    }
}