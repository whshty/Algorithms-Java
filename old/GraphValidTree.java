/*
 let's say the graph has V vertices and E edges, 
 the find( ) function takes O(V) time 
 because in the worst case it has to go through all the vertices, 
 and from outside we loop through all the edges, 
 so the time complexity should be O(V*E).
*/
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            
            // union
            nums[x] = y;
        }
        
        return edges.length == n - 1;
    }
    
    int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}