class Solution {
    public boolean canTransform(String start, String end) {
        if( start.length() != end.length() ) return false;
        char[] left = start.toCharArray();
        char[] right = end.toCharArray();
        for( int i = 0 ; i < start.length() ; i++ ){
            if( left[i] == right[i] ) continue;
            if( left[i] != 'X' && right[i] != 'X') return false;
            if( left[i] == 'L' && right[i] == 'X') return false;
            if( left[i] == 'X' && right[i] == 'R') return false;
            if( left[i] == 'R' && right[i] == 'X') {
                int nextR = findNext(left, i+1, 'X', 'R');
                if (nextR == -1) return false;
                else swap(left, i, nextR);
            } else if (left[i] == 'X' && right[i] == 'L'){
                int nextL = findNext(left,i+1,'L','X');
                if( nextL == -1 ) return false;
                else swap(left,i,nextL);
            }
        }
        return true;
    }
    private int findNext(char[] left, int pos, char target, char skip){
        for( int i = pos ; i < left.length ; i++ ){
            if( left[i] == target ) return i;
            else if( left[i] == skip ) continue;
            else return -1;
        }
        return -1;
    }
    private void swap(char[] chs, int i , int j){
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}