class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if( root == null ) return res;
        List<Node> list = new ArrayList<>();
        helper(root,list,0);
        
        for( Node node : list ){
            res.add(node.sum/node.count);
        }
        return res;        
    }
    
    public void helper(TreeNode node, List<Node> list, int level){
        if( node == null ) return;
        if( list.size() == level ){
            Node temp = new Node((double)node.val,1);
            list.add(temp);
        } else {
            Node cur = list.get(level);
            cur.count++;
            cur.sum += node.val;
        }
        helper(node.left,list,level+1);
        helper(node.right,list,level+1);   
    }    
}

class Node {
    double sum;
    int count;
    Node(double d, int i ){
        this.sum = d;
        this.count = i;
    }
}