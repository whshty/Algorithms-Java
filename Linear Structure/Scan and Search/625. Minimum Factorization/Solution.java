class Solution {
    public int smallestFactorization(int n) {
        if( n < 10 ) return n;
        
        List<Integer> list = new ArrayList<>();
        for( int i = 9 ; i > 1; i--){
            while ( n % i  == 0 ) {
                n = n / i;
                list.add(i);
            } 
        }
        if( n != 1 ) return 0;
        
        long res = 0;
        for( int i = list.size() - 1 ; i >= 0 ; i -- ){
            res = res * 10 + list.get(i);
            if( res > Integer.MAX_VALUE ) return 0;
        }
        return (int)res;
    }
}