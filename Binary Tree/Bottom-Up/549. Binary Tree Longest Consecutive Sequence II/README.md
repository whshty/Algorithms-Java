## Bottom - Up

```java
class Solution {
    public int longestConsecutive(TreeNode root) {
        int[] res = new int[1];
        if (root == null) return res[0];
        getLongestPath(root, res);
        return res[0];
    }

    private Result getLongestPath(TreeNode root, int[] res) {
        if (root == null) return new Result(0,0);
        int increase = 1, decrease = 1;
        if (root.left != null) {
            Result leftResult = getLongestPath(root.left, res);
            if (root.val == root.left.val + 1) {
                decrease = leftResult.decrease + 1;
            } else if (root.val == root.left.val - 1) {
                increase = leftResult.increase + 1;
            }
        }
        if (root.right != null) {
            Result rightResult = getLongestPath(root.right, res);
            if (root.val == root.right.val + 1) {
                decrease = Math.max(decrease, rightResult.decrease + 1);
            } else if (root.val == root.right.val - 1) {
                increase = Math.max(increase, rightResult.increase + 1);
            }
        }
        res[0] = Math.max(res[0], decrease + increase - 1);
        return new Result(increase, decrease);
    }

    class Result {
        int increase;
        int decrease;

        Result(int i, int j) {
            increase = i;
            decrease = j;
        }
    }
}
```