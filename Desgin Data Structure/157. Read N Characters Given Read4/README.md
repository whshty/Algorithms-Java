```java
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean isFinished = false; // end of file flag 
        int index = 0;
        char[] bufForRead4 = new char[4];
        while( !isFinished  && index < n){
            int totalToRead  = read4(bufForRead4);
            isFinished  = totalToRead  < 4 ; // totalToRead  == 4 -> false, continue to read
            totalToRead = Math.min(totalToRead , n - index);
            for(int i = 0 ; i < totalToRead ; i ++){
                buf[index++] = bufForRead4[i];
            }
        }
        return index;
    }
}
```