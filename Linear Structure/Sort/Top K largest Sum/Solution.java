public class Solution {
    public static void main(String[] args) {
        int[] input = new int[]{9,9,5,3,3,7,1};

        Solution sol = new Solution();
        int res = sol.topkSum(input,3);
        System.out.println(res);
    }

    public int topkSum(int[] nums, int k) {
        int[] frep = new int[10];
        for(int num : nums) {
            frep[num - 0]++;
        }
        int kSum = 0, count = k;
        for(int i = 9; i >= 0 && count > 0; i--) {
            if(count >= frep[i]) {
                kSum += frep[i] * i;
                count -= frep[i];
            } else {
                kSum += count * i;
                break;
            }
        }
        return kSum;
    }
}