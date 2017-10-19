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
```java
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

### Follow-Up : Copy A List of Graph Nodes

```java

import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        Node one = new Node(1);  
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        
        
        one.neighbors.add(two);
        one.neighbors.add(three);
        
        List<Node> input = new ArrayList<>();
        input.add(one);
        input.add(two);
        input.add(three);
        input.add(four);
        
        List<Node> res = cloneListOfGraph(input);    
    }
    public static List<Node> cloneListOfGraph(List<Node> nodes) {
        List<Node> res = new ArrayList<>();
        if( nodes == null || nodes.size()== 0 ) return res;
        
        Map<Node,List<Node>> map = new HashMap<>(); 
        Set<Node> set = new HashSet<>();
        for( Node node : nodes ){
            if(set.contains(node)){
                res.add(cloneGraph(findClonedNode(node,res),set));
            }
            else res.add(cloneGraph(node,set));
        }
        return res;  
    }
    
    
    public static Node findClonedNode(Node node, List<Node> list){
        if( node == null ) return null;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        
        while( !queue.isEmpty() ){
            Node cur = queue.poll();
            if( cur == node) return cur;
            for(Node neighbor : cur.neighbors){
                queue.add(neighbor);
            }
        }
        return null;
        
    }
     
    public static Node cloneGraph(Node node, Set<Node> set) {
        if( node == null ) return null;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        set.add(node);
        Map<Node,Node> map = new HashMap<>();
        map.put(node, new Node(node.label));
        
        while( !queue.isEmpty() ){
            Node cur = queue.poll();
            for(Node neighbor : cur.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.label));
                    queue.add(neighbor);
                    set.add(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
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