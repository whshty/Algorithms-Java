```java
public class Solution extends Reader4 {
    // store the data received in previous calls
    private int pointer = 0;
    private int count = 0; 
    private char[] bufferForRead4 = new char[4];
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buffer, int n) {
        int index = 0;
        while( index < n ){
            // start new read , put data into temp buff 
            if( pointer == 0 ) {
                count = read4(bufferForRead4);
                //if( bufferForRead4 == null || bufferForRead4.length == 0 ) return index;
            }
            if( count == 0 ) break;
            //while( index == 0 || buffer[index-1] == '\n')
            while( index < n && pointer < count ) {
                buffer[index++] = bufferForRead4[pointer++];
                //if(buffer[index-1] == '\n') break;
            }
            // reset bufferPointer
            if( pointer == count ) pointer = 0;
        }
        return index;
    }
}
```