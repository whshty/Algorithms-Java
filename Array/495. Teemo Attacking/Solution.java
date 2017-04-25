public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if( timeSeries.length == 0 ) return 0;
        
        int begin = timeSeries[0];
        int total = 0;
        
        for( int  t : timeSeries ){
            if( t < begin + duration ){
                total += t - begin;
            } else {
                total += duration;
            }
            begin = t;
        }
        return total + duration;
    }
}