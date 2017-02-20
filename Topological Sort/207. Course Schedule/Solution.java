public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,Node> map = new HashMap<>();
        for(int i=0 ; i < prerequisites.length;i++){
            Node node1 = map.getOrDefault(prerequisites[i][0],new Node(prerequisites[i][0]));
            Node node2 = map.getOrDefault(prerequisites[i][1],new Node(prerequisites[i][1]));
            node2.neighbors.add(node1);
            node1.parents++;
            map.put(prerequisites[i][0],node1);
            map.put(prerequisites[i][1],node2);
        }
        Queue<Node> queue = new LinkedList<>();
        for( Node node : map.values()){
            if( node.parents == 0 ){
                queue.offer(node);
            }
        }
        while( !queue.isEmpty()){
            Node node = queue.poll();
            map.remove(node.val);
            for( Node neigh : node.neighbors ){
                neigh.parents--;
                if( neigh.parents == 0 && map.containsKey(neigh.val)){
                    queue.offer(neigh);
                }
            }
        }
        return map.isEmpty();
    }
}

class Node {
    int val;
    int parents;
    LinkedList<Node> neighbors;
    public Node( int val){
        this.val = val;
        parents =0;
        neighbors = new LinkedList<>();
    }
}