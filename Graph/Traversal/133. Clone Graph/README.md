

## 1. Copy A Graph Node : HashMap To Saved Cloned Nodes

```java
class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { 
		label = x; 
		neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
}
```
```java
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if( node == null ) return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
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

## 2.Follow-Up : Copy A List of Graph Nodes

```java
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.neighbors.add(two);
        one.neighbors.add(three);
        two.neighbors.add(three);

        List<Node> input = new ArrayList<>();
        input.add(one);
        input.add(two);
        input.add(three);
        input.add(four);

        List<Node> res = cloneListOfGraph(input);

        for (Node temp : res) {
            System.out.println(temp.label);
        }
    }

    public static List<Node> cloneListOfGraph(List<Node> nodes) {
        List<Node> res = new ArrayList<>();
        if (nodes == null || nodes.size() == 0) return res;

        Map<Node, Node> map = new HashMap<>();
        for (Node node : nodes) {
            if (map.containsKey(node)) {
                res.add(map.get(node));
            } else {
                res.add(cloneGraph(node,map));
            }
        }
        return res;
    }



    public static Node cloneGraph(Node node, Map<Node, Node> map) {
        if (node == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);


        map.put(node, new Node(node.label));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.label));
                    queue.add(neighbor);

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
        neighbors = new ArrayList<>();
    }
}
```