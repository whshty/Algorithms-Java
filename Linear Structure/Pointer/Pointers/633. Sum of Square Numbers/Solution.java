class Solution {
    public boolean judgeSquareSum(int c) {
        if( c < 0 ) return false;
        int start = 0 , end = (int)Math.sqrt(c);
        
        while( start <= end  ){
            int res = start * start + end * end;
            if( res ==  c )  return true;
            else if ( c > res ) end--;
            else start++;
        }
        return false;
    }
}