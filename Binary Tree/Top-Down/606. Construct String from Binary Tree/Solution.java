public class Solution {
    public String tree2str(TreeNode t) {
        if(  t == null ) return "";
        StringBuilder sb = new StringBuilder();
        helper(t,sb,false);
        return sb.substring(1,sb.length()-1);
    }
    private void helper(TreeNode node, StringBuilder sb , boolean isLeft){
        if( node == null ){
            if( isLeft ){
                sb.append("()");
            }
            return;
        }
        sb.append("(").append(node.val);
        if( node.left != null || node.right != null ){
            helper(node.left,sb,true);
            helper(node.right,sb,false);
        }
        sb.append(")");   
    }
}


public class Solution {
    public String tree2str(TreeNode t) {
        if( t == null ) return "";
        
        String result = t.val + "";
        
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        
        if( left == "" && right == "") return result;
        if( left == "" && right != "") return result + "()" + "(" + right + ")";
        if( left != "" && right == "") return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";
    }
}