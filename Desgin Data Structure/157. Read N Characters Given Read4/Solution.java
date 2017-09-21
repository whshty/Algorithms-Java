public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean isFinished = false; // end of file flag 
        int res = 0;
        char[] temp = new char[4];
        while( !isFinished  && res < n){
            int count = read4(temp);
            isFinished  = count < 4 ; // count == 4 -> false;
            count = Math.min(count, n-res);
            for(int i = 0 ; i < count ; i ++){
                buf[res++] = temp[i];
            }
        }
        return res;
    }
}