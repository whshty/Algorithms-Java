// time : o(n);
// space : o(1);
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        // end of file flag
        boolean eof = false;
        // total bytes have read
        int total = 0;
        // temp buffer
        char[] tmp = new char[4];
        while ( !eof && total < n){
            int count = read4(tmp);
            // check if it is the end of the file
            eof = count < 4;
            // get the actual count
            count = Math.min(count, n - total);
            //copy to buf 
            for(int i = 0 ; i < count ; i++ ){
                buf[total++] = tmp[i];
            }
        }
        return total;
    }
}