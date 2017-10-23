public class Solution extends Reader4 {
    // store the data received in previous calls
    int read4Pointer = 0; 
    int totalToRead = 0; 
    char[] bufferForRead4 = new char[4];
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buffer, int n) {
        int index = 0;
        while( index < n){
            //if( read4Pointer > 0 && bufferForRead4[read4Pointer-1] == '\n') break;
            //start new read , put data into temp buff 
            if( read4Pointer == 0 ) totalToRead = read4(bufferForRead4);
            //if( bufferForRead4 == null || bufferForRead4.length == 0 ) return index;
            if( totalToRead == 0 ) break;
            
            //while( index == 0 || buffer[index-1] == '\n')
            while( index < n && read4Pointer < totalToRead ) {
                buffer[index++] = bufferForRead4[read4Pointer++];
                //if(buffer[index-1] == '\n') break;
            }
            if( read4Pointer == totalToRead ) read4Pointer = 0;
        }
        return index;
    }
}