public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if( n == 0 ) return res;
        dfs(n,k,res,new ArrayList<>(),1);
        return res;
    }
    private void dfs(int n, int k , List<List<Integer>> res, List<Integer> list, int pos){
        if( list.size() == k ){
            res.add(new ArrayList<>(list));
            return;
        }
        for( int i = pos ; i <= n ; i++ ){
            list.add(i);
            dfs(n,k,res,list,i+1);
            list.remove(list.size()-1);
        }
    }
}