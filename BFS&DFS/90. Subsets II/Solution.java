public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if( nums == null || nums.length == 0 ) return res;
        dfs(res,new ArrayList<Integer>(),nums,0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int pos){
        res.add(list);
        for( int i = pos ; i < nums.length ; i++ ){
            if( i > pos && nums[i] == nums[i-1]) continue;
            List<Integer> tempList = new ArrayList<>(list);
            tempList.add(nums[i]);
            dfs(res,tempList,nums,i+1);
        }
    }
}