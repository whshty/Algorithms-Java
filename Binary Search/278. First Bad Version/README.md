```
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = ( start + end ) >>> 1;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;            
        }        
        return start;
    }
}

```