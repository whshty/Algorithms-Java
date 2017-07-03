public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        if( candidates == null || candidates.length == 0 ) return res;
        dfs(candidates,target,res,new ArrayList<>(),0);
        return res;  
    }
    private void dfs(int[] candidates, int sum, List<List<Integer>> res, List<Integer> list, int pos){
        if( sum < 0 ) return;
        if( sum == 0 ){
            res.add(new ArrayList<>(list));
            return;
        }
        for( int i = pos ; i < candidates.length ; i++ ){
        	if( i > pos &&  candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            dfs(candidates, sum - candidates[i],res,list,i+1);
            list.remove(list.size()-1);
        }
    }
}