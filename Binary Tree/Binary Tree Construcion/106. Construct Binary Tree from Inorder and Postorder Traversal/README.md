
## Recursion
* Find the last node in postorder[], in our case, it's 1
* Search 1 in inorder[] to find the left and right subtrees of root 1
* Recur the above process for following two
* Time : o(n^2)

![](https://github.com/RagingPsyduck/Data-Structures-and-Algorithms-in-Java/blob/master/Binary%20Tree/Binary%20Tree%20Construcion/106.%20Construct%20Binary%20Tree%20from%20Inorder%20and%20Postorder%20Traversal/Picture/demo.png)


```
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0 ) return null;
        return build(inorder,0,inorder.length-1,postorder,postorder.length-1);
    }
    
    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postEnd){
        if( inStart > inEnd ) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        if( inStart == inEnd ) return root;
        int inorderRoot = 0;
        for( int i = inStart ; i <= inEnd ; i++){
            if( inorder[i] == root.val) {
                inorderRoot = i;
                break;
            }
        }
        
        int rightTreeLen = inEnd - inorderRoot;
        root.left = build(inorder,inStart,inorderRoot-1,postorder,postEnd-rightTreeLen-1);
        root.right = build(inorder,inorderRoot+1,inEnd,postorder,postEnd-1);
        
        return root;
    }
}
```