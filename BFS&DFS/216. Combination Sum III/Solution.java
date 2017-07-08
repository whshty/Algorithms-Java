public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(k,n,res,new ArrayList<Integer>(),1);
        return res;
    }
    
    private void dfs(int k , int n , List<List<Integer>> res, List<Integer> list, int start){
        if( n == 0 && list.size() == k ){
            res.add(new ArrayList<>(list));
            return;
        }
        for( int i = start ; i <= 9 ; i++ ){
            list.add(i);
            dfs(k,n-i,res,list,i+1);
            list.remove(list.size()-1);
        }
    }
}