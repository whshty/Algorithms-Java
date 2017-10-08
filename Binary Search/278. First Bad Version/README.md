```
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = ( start + end ) >>> 1;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;   // if end = mid - 1 [t,f,f], the output will be 1, but it should be 2     
        }        
        return start; // can also return end
    }
}

```