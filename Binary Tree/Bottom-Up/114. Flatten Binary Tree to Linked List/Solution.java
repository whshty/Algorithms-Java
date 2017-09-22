class Solution {
    public void flatten(TreeNode root) {
        if(  root == null ) return;
        TreeNode right = root.right;
        
        flatten(root.left);
        flatten(root.right);
        
        root.right = root.left;
        root.left = null;
        while( root.right != null ){
            root = root.right;
        }
        root.right = right;
    }
}

// use stack to save node.
// Preorder traversal 
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
            if(!stack.isEmpty()) node.right = stack.peek();
            node.left = null;
        }
    }
}

// DLL 1
public class BTtoDLL{

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        BTtoDLL sol = new BTtoDLL();

        sol.convert(root);
        sol.generateCycle(head);

        while ( root != null ){
            System.out.print(head.val);
            head = head.right;
        }
    }

    TreeNode prev = null;
    static TreeNode head;
    public void convert(TreeNode root){

        if(root == null ) return;
        convert(root.left);
        if(prev == null){
            head = root;

        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convert(root.right);
    }

    public void generateCycle(TreeNode root){
        TreeNode pre = root , head = root;
        while( head.right != null ){
            head = head.right;
        }
        head.right = pre;
        pre.left = head;
    }



}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
// DLL 2

public class Solution{
    static TreeNode prev = null;
    static TreeNode head;
    public void covert(TreeNode root){
        if(root == null ) return;
        convert(root.left);
        if(prev == null){
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convert(root.right)
    }
    public void generateCycle(ListNode root){
        ListNode pre = root , head = root;
        while( head.right != null ){
            head = head.right;
        }
        head.right = pre;
        pre.left = head;
    }
}

class ListNode {
     int val;
     ListNode left;
     ListNode right;
     ListNode(int x) { val = x; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}