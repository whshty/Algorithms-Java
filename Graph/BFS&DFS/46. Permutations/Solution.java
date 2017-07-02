// bfs
// time complexity 
// time O(n!)
// space O(n!)
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if( nums == null || nums.length == 0 ) return res;
        res.add(new ArrayList<Integer>());
        
        for( int i = 0 ; i < nums.length ; i++ ){
            List<List<Integer>> nextRes = new ArrayList<List<Integer>>();
            for( List<Integer> list : res ){
                for( int j = 0 ; j <= list.size() ; j++ ){
                    List<Integer> nextList = new ArrayList<Integer>(list);
                    nextList.add(j,nums[i]);
                    nextRes.add(nextList);
                }
            }
            res = nextRes;
        }
        return res;
    }
}

// time O(n! * n )
// space O(n)
// no recursion stack

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if( nums == null || nums.length == 0 ) return res;
        List<Integer> list = new ArrayList<>();
        dfs(nums,res,list);
        return res;
    }
    private void dfs(int nums[], List<List<Integer>> res, List<Integer> list ){
        if( list.size() == nums.length ){
            res.add(new ArrayList<Integer>(list));
            return;
        } 
        for( int i = 0 ; i < nums.length ; i++ ){
            if( !list.contains(nums[i])){
                list.add(nums[i]);
                dfs(nums,res,list);
                list.remove(list.size()-1);
            }
        }
    }
}