class Solution {
    public int monotoneIncreasingDigits(int num) {
        if( num <= 9 ) return num;
        char[] chs = String.valueOf(num).toCharArray();
        
        int mark = chs.length;
        for( int i = chs.length - 1 ; i >= 1 ; i--){
            if( chs[i] < chs[i-1] ){
                mark = i - 1;
                chs[i-1]--;
            }
        }
        
        for( int i = mark + 1; i < chs.length ; i++ ){
            chs[i] = '9';
        }
        return Integer.parseInt(new String(chs));
    }
}