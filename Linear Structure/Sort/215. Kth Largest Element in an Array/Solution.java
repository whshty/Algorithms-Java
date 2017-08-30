public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int pos = quickSelect(nums, 0 , n - 1 , n- k + 1);
        return nums[pos];
    }
    public int quickSelect(int[] a, int left , int right , int k){
        int i = left , j = right , pivot = a[right];
        while( i < j ){
            if( a[i++] > pivot ){
                swap(a,--i,--j);
            }
        }
        swap(a,i,right);
            
        int pos = i - left + 1;
        if( pos == k) return i;
        else if( pos > k ) return quickSelect(a,left,i-1,k);
        else return quickSelect(a,i+1,right,k-pos);
    }
    public void swap(int[] n, int i , int j){
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }
}