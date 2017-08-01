public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n,res,new ArrayList<>(),2);
        return res;
    }
    private void dfs( int n , List<List<Integer>> res , List<Integer> list, int pos) {
        if( n == 1 ){
            if ( list.size() > 1){
                res.add(new ArrayList<>(list));
            }
            return;
        }   
        for( int i = pos ; i <= n ; i++ ){
            if( n % i == 0 ){
                list.add(i);
                dfs(n/i,res,list,i);
                list.remove(list.size()-1);
            }
        }
    }
}