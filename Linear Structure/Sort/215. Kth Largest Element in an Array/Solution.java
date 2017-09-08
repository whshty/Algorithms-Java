public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}


public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for( int i : nums){
            heap.offer(i);
            if( heap.size() > k ){
                heap.poll();
            }
        }
        return heap.peek();
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int pos = quickSelect(nums, 0 , n - 1 , n- k + 1);
        return nums[pos];
    }
    public int quickSelect(int[] nums, int left , int right , int k){
        int i = left , j = right , pivot = nums[right];
        while( i < j ){
            if( nums[i++] > pivot ){
                swap(nums,--i,--j);
            }
        }
        swap(nums,i,right);
            
        int pos = i - left + 1;
        if( pos == k) return i;
        else if( pos > k ) return quickSelect(nums,left,i-1,k);
        else return quickSelect(nums,i+1,right,k-pos);
    }
    public void swap(int[] n, int i , int j){
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }
}