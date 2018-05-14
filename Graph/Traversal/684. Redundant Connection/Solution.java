class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] nums = new int[2001];
        for (int i = 0 ; i < nums.length ; i++) nums[i] = i;
        
        for (int[] edge : edges) {
            int edge1 = edge[0] , edge2 = edge[1];
            int id1 = find(nums,edge1), id2 = find(nums,edge2);
            if( id1 == id2 ) return edge;
            else nums[id2] = id1;
        }
        return new int[2];
    }
    
    private int find (int[] nums, int id){
        if (nums[id] != id) nums[id] = find(nums, nums[id]);
        return nums[id];
    }
}