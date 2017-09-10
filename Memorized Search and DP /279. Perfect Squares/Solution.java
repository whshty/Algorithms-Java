public class Solution {
    public int numSquares(int n) {
        if( n ==  1 ) return 1;
        Map<Integer,Integer> map = new HashMap<>();
        return dfs(n,map);
    }
    public int dfs(int n, Map<Integer,Integer> map){
        if( n == 0 ) return 0;
        if( n == 1 ) return 1;
        if(map.containsKey(n)) return map.get(n);
        int k = (int)Math.sqrt(n);
        int min = Integer.MAX_VALUE;
        for( int i = 1; i <= k ; i++ ){
            int temp = n -  ( i * i );
            int res = dfs(temp,map) +  1;
            if( res >= 0 ) min = Math.min(min,res);
        }
        map.put(n,min);
        return map.get(n);
    }
}