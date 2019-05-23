
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] test1 = new int[]{3, 1, 2};
        int[] test2 = new int[]{8, 3, 5, 2, 15};
        System.out.println(sol.getMinResult(test1));
        System.out.println(sol.getMinResult(test2));
    }

    public int getMinResult(int[] input) {
        PriorityQueue<Integer> heap
                = new PriorityQueue<>();
        for (int i : input) {
            heap.add(i);
        }
        int result = 0;

        while (heap.size() > 1) {
            int temp = heap.poll() + heap.poll();
            result += temp;
            heap.add(temp);
        }
        return result;

    }

}

