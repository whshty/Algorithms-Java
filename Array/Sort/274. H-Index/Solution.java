public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] buckets = new int[len+1];
        
        for( int i : citations ){
            if( i > len ){
                buckets[len]++;
            } else {
                buckets[i]++;
            }
        } 
        int count = 0;
        for( int i = len ; i >= 0 ; i-- ){
            count += buckets[i];
            if( count >= i ){
                return i;
            }
        }
        return 0;
    }
}