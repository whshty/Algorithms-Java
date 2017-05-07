public class Solution {
    public int findPeakElement(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    public int helper( int[] num  , int start , int end){
        if( start == end ){
            return start;
        } else if ( start+1 == end ){
            if(num[start] > num[end]) return start;
            return end;
        } else {
            int mid = start + ( end - start ) / 2 ;
            if ( num[mid] > num[mid-1] && num[mid] > num[mid+1]){
                return mid;
            } else if( num[mid-1] > num[mid] && num[mid] > num[mid+1]){
                return helper(num,start,mid-1);
            } else{
                return helper(num,mid+1,end);
            }
        }
    }
}