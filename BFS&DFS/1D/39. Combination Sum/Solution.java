public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if( candidates == null || candidates.length == 0 ) return res;
        dfs(candidates,target,res,new ArrayList<>(),0);
        return res;
    }
    private void dfs(int[] candidates, int sum, List<List<Integer>> res, List<Integer> list, int pos){
        if( sum < 0 ) return;
        if( sum == 0 ){
            res.add(list);
            return;
        }
        for( int i = pos ; i < candidates.length ; i++ ){
            List<Integer> tempList = new ArrayList<>(list);
            tempList.add(candidates[i]);
            dfs(candidates, sum - candidates[i],res,tempList,i);
        }
    }
}