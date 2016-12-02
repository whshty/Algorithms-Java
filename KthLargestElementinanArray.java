// Arrays.sort() methods uses a tuned quicksort with a time complexity of ) O(n*lgn) 
// sort all elements
// time ：O(N lg N) + O(k) 
// space : O(1) memory
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

// heap : sort largest k elements 
// poll the smallest one
// heapify -> o(k)
// heap : pull / push an element : logk 
// time : O(N lg K) running time
// space : o(k)
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int vals : nums){
            heap.offer(vals);
             if(heap.size() > k ){
                heap.poll();    
            }
        }
        return heap.peek();
    }
}
// heap use extra space
// quick select (without extra space)
// time :average n + n/2 + n/4 + ..... = 2n = 0(n);
// time : worse n + (n-1) + (n-2) + ..... + 1 = o(n^2);
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1,nums.length-k);    
    }
    public int quickSelect(int[] n, int start, int end, int k){
        int pivot = n[end] , pos = start;
        // take end as pivot
        for( int i = start ; i < end ; i++){
            if(n[i] <= pivot) swap(n,i,pos++);
        }
        // set pivot to the partition position
        swap(n,pos,end);
        if(pos==k) return n[pos];
        else return pos < k ? quickSelect(n,pos+1,end,k) : quickSelect(n,start,pos-1,k);
    }
    private void swap(int[] n, int i,int j){
        if(n[i] == n[j]) return;
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }
}