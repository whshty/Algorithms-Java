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
        int len = nums.length;
        return quickSelect(nums,0,len-1,len-k+1);
    }
    
    public int quickSelect(int[] nums, int start , int end , int k){
        int i = start , j = end, pivot = nums[end];
        while( i < j ) {
            if( nums[i++] > pivot ) {
                swap(nums,--i,--j);
            }
        }
        swap(nums,i,end);
        int index = i - start + 1;
        if( index == k ) return nums[i];
        else if( index > k ) return quickSelect(nums,start,i-1,k);
        else return quickSelect(nums,i+1,end,k-index);
    }
    public void swap(int[] nums, int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


public class Solution {
    public List<int[]> findKth2D(List<int[]> list, int k){
        int[] nums = new int[list.size()];
        Map<Integer,List<int[]>> map = new HashMap<>();

        for( int i = 0 ; i < list.size() ; i++ ){
            int[] temp = list.get(i);
            nums[i] = temp[0] * temp[0] + temp[1] * temp[1];
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(temp);
        }

        int kVal = findKthLargest(nums,k);
        return map.get(kVal);
    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return quickSelect(nums,0,len-1,len-k+1);
    }

    public int quickSelect(int[] nums, int start , int end , int k){
        int i = start , j = end, pivot = nums[end];
        while( i < j ) {
            if( nums[i++] > pivot ) {
                swap(nums,--i,--j);
            }
        }
        swap(nums,i,end);
        int index = i - start + 1;
        if( index == k ) return nums[i];
        else if( index > k ) return quickSelect(nums,start,i-1,k);
        else return quickSelect(nums,i+1,end,k-index);
    }
    public void swap(int[] nums, int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

