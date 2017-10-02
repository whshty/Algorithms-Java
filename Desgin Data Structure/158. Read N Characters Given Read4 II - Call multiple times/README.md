```
public class Solution extends Reader4 {
    // store the data received in previous calls
    private int pointer = 0;
    private int count = 0; 
    private char[] temp = new char[4];
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int index = 0;
        while( index < n ){
            // start new read , put data into temp buff 
            if( pointer == 0 ) count = read4(temp);
            if( count == 0 ) break;
            while( index < n && pointer < count ) {
                buf[index++] = temp[pointer++];
            }
            // reset bufferPointer
            if( pointer == count ) pointer = 0;
        }
        return index;
    }
}
```