public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        
        int max = findMax(nums,start,end);   
        TreeNode root = new TreeNode(nums[max]);
        root.left = helper(nums, start, max - 1);
        root.right = helper(nums, max + 1, end);
        return root;
    }
    private int findMax(int[] nums, int start , int end){
        int max = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }
}