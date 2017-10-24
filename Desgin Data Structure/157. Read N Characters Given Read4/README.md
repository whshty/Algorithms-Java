```java
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int index = 0;
        char[] bufForRead4 = new char[4];
        while( index < n ){
            int totalToRead = read4(bufForRead4);
            if( totalToRead == 0 ) break;
            totalToRead = Math.min(n-index,totalToRead);// if n - index = 2 but toRead is 3
            for( int i = 0 ; i < totalToRead ; i++ ){
                buf[index++] = bufForRead4[i];
            }
            
        }
        return index;
    }
}
```