class Solution {
    public boolean hasAlternatingBits(int n) {
        int pre = n % 2;
        n = n / 2;
        while( n > 0 ){
            int cur = n % 2 ;
            if( cur == pre ) return false;
            pre = cur;
            n = n / 2;
        }
        return true;
    }
}

class Solution {
    public boolean hasAlternatingBits(int n) {
        int pre = n & 1;
        n = n >> 1;
        while( n > 0 ){
            int cur = n & 1 ;
            if( cur == pre ) return false;
            pre = cur;
            n = n >> 1;
        }
        return true;
    }
}