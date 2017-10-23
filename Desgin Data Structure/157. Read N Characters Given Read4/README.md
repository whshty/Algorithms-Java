```java
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean isFinished = false;
        int index = 0;
        char[] bufForRead4 = new char[4];
        while( !isFinished && index < n ){
            int totalToRead = read4(bufForRead4);
            if( totalToRead < 4 ) isFinished = true; // totalToRead  == 4 -> false, continue to read
            totalToRead = Math.min(n-index,totalToRead);// if n - index = 2 but toRead is 3
            for( int i = 0 ; i < totalToRead ; i++ ){
                buf[index++] = bufForRead4[i];
            }
            
        }
        return index;
    }
}
```