class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        double[] gap = new double[stations.length-1];
        for( int i = 0 ; i < stations.length - 1 ; i++ ){
            gap[i] = stations[i+1] - stations[i];
        }
        
        double start = 0 , end = Integer.MAX_VALUE, diff = 1e-6;
        while( start + diff < end ){
            double mid  = ( start + end ) / 2;
            if (isValid(gap,mid,k)) end = mid;
            else start = mid;
        }
        return start;
    }
    
    private boolean isValid(double[] gap, double maxGap, int k){
        int count = 0;
        for( int i = 0 ; i < gap.length ; i++ ){
            count += gap[i] / maxGap;
        }
        return count <= k;
    }
}