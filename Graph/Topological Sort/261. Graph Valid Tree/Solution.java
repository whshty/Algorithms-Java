public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if( n < 1 ) return false;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for( int i = 0 ; i < n ; i++ ) {
            map.put(i,new HashSet<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            if( set.contains(node)) return false;
            for( int temp : map.get(node)){
                queue.add(temp);
                map.get(temp).remove(node);
            }
            set.add(node);
        }
        return set.size() == n;
    }
}


public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if( n < 1 ) return false;
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for( int i = 0 ; i < n ; i++ ) map.put(i,new HashSet<>());
        for(int[] edge : edges ){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }    
        Set<Integer> set = new HashSet<>();
        set.add(0);
        boolean res = hasCycle(map,set,0,-1);
        if(!res) return false;
        return set.size() == n;
    }
    
    private boolean hasCycle( Map<Integer,Set<Integer>> map, Set<Integer> set , int cur, int parent){
        Set<Integer> list= map.get(cur);
        
        for( int i : list){
            if( i == parent ) continue;
            if( set.contains(i) ) return false;
            set.add(i);
            boolean res = hasCycle(map,set,i,cur);
            if( !res ) return false;
        }
        return true;
    }
}

// Input is List of TreeNode
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        node1.left = node2;
        node1.right = null;
        node2.left = node2.right = null;

        List<TreeNode> input = new ArrayList<>();
        input.add(node1);
        input.add(node2);

        Solution sol = new Solution();

        System.out.println(sol.validTree(input));


    }

    public boolean validTree(List<TreeNode> list) {
        Map<TreeNode, Set<TreeNode>> map = new HashMap<>();
        Map<TreeNode, Integer> indegree = new HashMap<>();

        for (TreeNode node : list) {
            map.putIfAbsent(node, new HashSet<>());
            indegree.putIfAbsent(node, 0);
        }

        for (TreeNode node : list) {
            Set<TreeNode> set = map.get(node);
            if (node.left != null) {
                set.add(node.left);
                indegree.put(node.left, indegree.get(node.left) + 1);
            }
            if (node.right != null) {
                set.add(node.right);
                indegree.put(node.right, indegree.get(node.right) + 1);
            }
        }
        List<TreeNode> roots = new ArrayList<>();
        for (TreeNode node : indegree.keySet()) {
            if (indegree.get(node) == 0) roots.add(node);
        }

        if (roots.size() > 1 || roots.size() == 0) return false;
        TreeNode root = roots.get(0);

        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (set.contains(node)) return false;

            for (TreeNode temp : map.get(node)) {
                indegree.put(temp,indegree.get(temp) -1 );
                if( indegree.get(temp) == 0 ) {
                    queue.add(temp);
                }
            }
            set.add(node);
        }
        return set.size() == list.size();
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


