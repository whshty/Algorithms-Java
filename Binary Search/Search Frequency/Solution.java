package Solution;

public class Solution {
    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 2, 2, 2, 2, 3, 4};
        int res = searchValue(input);
        System.out.println(res);
    }

    public static int searchValue(int[] nums) {
        int len = nums.length;
        int minLne = len / 4;

        int onePos = minLne * 1;
        int twoPos = minLne * 2;
        int threePos = minLne * 3;


        if (getLen(nums, onePos) > minLne) return nums[onePos];
        else if (getLen(nums, twoPos) > minLne) return nums[twoPos];
        else if (getLen(nums, threePos) > minLne) return nums[threePos];
        else return -1;
    }

    private static int getLen(int[] nums, int pos) {
        int start = 0, end = nums.length - 1;
        int i = binarySearchLeft(nums, nums[pos], start, pos);
        int j = binarySearchRight(nums, nums[pos], pos, end);
        return j - i + 1;
    }


    private static int binarySearchLeft(int[] nums, int val, int start, int end) {
        while (start < end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == val) {
                end = mid - 1;
            } else start = mid + 1;
        }
        return end;
    }

    private static int binarySearchRight(int[] nums, int val, int start, int end) {
        while (start < end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == val) {
                start = mid + 1;
            } else end = mid;
        }
        return start;
    }
}

