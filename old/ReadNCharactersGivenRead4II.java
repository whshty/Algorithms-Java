/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    // store the data received in previous calls
    private int bufferPointer = 0;
    private int bufferCount = 0; 
    private char[] buff = new char[4];
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int pointer = 0;
        while( pointer < n ){
            // start new read , put data into temp buff 
            if( bufferPointer == 0 ) bufferCount = read4(buff);
            if( bufferCount == 0 ) break;
            while( pointer < n && bufferPointer < bufferCount ) {
                buf[pointer++] = buff[bufferPointer++];
            }
            // reset bufferPointer
            if(bufferPointer==bufferCount) bufferPointer = 0;
        }
        return pointer;
    }
}