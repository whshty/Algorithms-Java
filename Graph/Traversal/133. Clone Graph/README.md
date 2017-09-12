```
class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { 
		label = x; 
		neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
}
```

### BFS
```
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if( node == null ) return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, new UndirectedGraphNode(node.label));
        
        while( !queue.isEmpty() ){
            UndirectedGraphNode cur = queue.poll();
            for(UndirectedGraphNode neighbor : cur.neighbors){
                if( !map.containsKey(neighbor)){
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}

```

### Copy a list of graph nodes

```
import java.io.*;
import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {

        
    }
    public List<Node> cloneListOfGraph(List<Node> nodes) {
        List<Node> res = new ArrayList<>();
        if( nodes == null || nodes.size()== 0 ) return res;
        
        Set<Node> set = new HashSet<>(); 
        for( Node node : nodes ){
            res.add(cloneGraph(node,set));
            
        }
        return res;  
 
    }
     
    private Node cloneGraph(Node node, Set<Node> set){
        if( node == null ) return null;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        set.add(node);
        Map<Node, Node> map = new HashMap<Node, Node>();
        map.put(node, new Node(node.label));
        
        while( !queue.isEmpty() ){
            Node cur = queue.poll();
            // handle the neighors
            for(Node temp : cur.neighbors){
                if( !map.containsKey(temp)){
                    map.put(temp, new Node(temp.label));
                    queue.add(temp);
                    set.add(temp);
                }
                map.get(cur).neighbors.add(map.get(temp));
            }
        }
        return map.get(node);
    } 
}

class Node {
    int label;
    List<Node> neighbors;
    Node(int x) { 
        label = x; 
        neighbors = new ArrayList<Node>(); 
    }
}

```