class Solution {
    public int maxProfit(int[] prices) {
        int cur = 0 , preCur = 0 , cost = Integer.MIN_VALUE , preCost = cost;
        for( int i : prices ){
            preCost = cost;
            cost = Math.max(preCur - i,preCost);
            preCur = cur ;
            cur  = Math.max(preCost + i,preCur);
        }
        return cur;
    }
}