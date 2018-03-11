class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {        
        List<Integer> res = new ArrayList<>();
        for( int i = left ; i <= right ; i++ ){
            int cur = i;
            while ( cur > 0 ){
                if( cur % 10 == 0 || i % ( cur % 10 ) != 0 ) break;
                cur /= 10;
            }
            if( cur == 0 ) res.add(i);
        }
        return res;
    }
}