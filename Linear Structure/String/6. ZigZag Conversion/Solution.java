class Solution {
    public String convert(String s, int n) {
        char[] chs = s.toCharArray();
        int len = s.length();
        StringBuilder[] sbs = new StringBuilder[n];
        for( int i = 0 ; i < n ; i++ ) sbs[i] = new StringBuilder();

        int index = 0;
        while( index < len ){
            for( int i = 0 ; i < n && index < len ; i++ ) sbs[i].append(chs[index++]);
            for( int i = n - 2 ; i >= 1 && index < len ; i-- ) sbs[i].append(chs[index++]);
        }
        for( int i = 1 ; i < sbs.length ; i++ ) sbs[0].append(sbs[i]);
        return sbs[0].toString();
    }
}