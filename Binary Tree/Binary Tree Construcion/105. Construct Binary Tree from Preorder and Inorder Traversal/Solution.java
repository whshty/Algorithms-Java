/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if( preorder.length != inorder.length ) return null;
        if( preorder.length == 0 || inorder.length == 0 ) return null;
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    
    public TreeNode helper(int[]preorder, int preStart, int preEnd, int inorder[], int inStart, int inEnd ){
        if( preStart > preEnd || inStart > inEnd ) return null;
    
        TreeNode root = new TreeNode(preorder[preStart]);
        int inorderRoot = inStart;
        for( int i = inStart ; i <= inEnd ; i++ ){
            if( inorder[i] == root.val){
                inorderRoot = i;
                break;
            }
        }
        
        int leftTreeLen = inorderRoot - inStart;
        root.left = helper(preorder,preStart+1,preStart+leftTreeLen,inorder,inStart,inorderRoot-1);
        root.right = helper(preorder,preStart+leftTreeLen+1,preEnd,inorder,inorderRoot+1,inEnd);
        
        return root;
    }
}

// Build Balanced BST based on Sorted Array
public class Solution {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        Solution sol = new Solution();
        TreeNode root = sol.sortedArrayToTree(arr, 0, arr.length - 1);
        System.out.println(root.val);

    }

    public TreeNode sortedArrayToTree(int[] input, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(input[mid]);

        root.left = sortedArrayToTree(input, start, mid - 1);
        root.right = sortedArrayToTree(input, mid + 1, end);
        return root;


    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}