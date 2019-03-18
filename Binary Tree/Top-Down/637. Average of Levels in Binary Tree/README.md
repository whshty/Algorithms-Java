```
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if( root == null ) return res;
        List<NodesOfSameLevel> list = new ArrayList<>();
        helper(root,list,0);
        
        for( NodesOfSameLevel nodes : list ){
            res.add(nodes.sum/nodes.count);
        }
        return res;        
    }
    
    public void helper(TreeNode node, List<NodesOfSameLevel> list, int level){
        if( node == null ) return;
        if( list.size() == level ){
            NodesOfSameLevel temp = new NodesOfSameLevel((double)node.val,1);
            list.add(temp);
        } else {
            NodesOfSameLevel cur = list.get(level);
            cur.count++;
            cur.sum += node.val;
        }
        helper(node.left,list,level+1);
        helper(node.right,list,level+1);   
    }    
}

class NodesOfSameLevel {
    double sum;
    int count;
    NodesOfSameLevel(double d, int i ){
        this.sum = d;
        this.count = i;
    }
}

```