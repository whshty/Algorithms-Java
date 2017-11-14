import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        int[] input = new int[]{2, 6, 3, 12, 56, 8};

        Solution sol = new Solution();
        sol.sortKsortedArray(input,3);

        for( int i : input){
            System.out.print(i + " ");
        }

    }

    public void sortKsortedArray(int[] input, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int i = 0;
        //Construct Heap for k+1 elements
        for (i = 0; i <= k && i < input.length; i++){
            minHeap.add(input[i]);
        }

        int index = 0;

        // Repeat the process until priority queue becomes empty.
        while (!minHeap.isEmpty()) {
            input[index++] = minHeap.poll();
            if (i < input.length)
                minHeap.add(input[i++]);
        }
    }
}