## Binary Search 
* Time : O(log(min(m,n)) 

```java
public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
	    int len1 = A.length, len2 = B.length;
	    int index1 = (len1 + len2 + 1) / 2;
	    int index2 = (len1 + len2 + 2) / 2;
	    return (getKth(A, 0, len1 - 1 , B, 0, len2 - 1 , index1) + getKth(A, 0, len1 -1  , B, 0, len2 - 1 , index2)) / 2.0;
	}

    public double getKth(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int index) { 
        // if we reach the end of A array 
        if( aStart > aEnd ) return B[bStart + index - 1];
        // if we reach the end of B array 
        if( bStart > bEnd ) return A[aStart + index - 1];
        
        int aMid = ( aStart + aEnd ) >>> 1;
        int bMid = ( bStart + bEnd ) >>> 1;
        
        //A[aMid] <= B[bMid], x: mid len of a, y: mid len of b, then wen can know
        //(1) there will be at least (x + 1 + y) elements before bMid
        //(2) there will be at least (m - x - 1 + n - y) = m + n - (x + y +1) elements after aMid
        int leftHalf =  (aMid - aStart) + (bMid - bStart) + 1;
        if( A[aMid] <= B[bMid]) {
            if ( index <= leftHalf) return getKth(A, aStart, aEnd, B, bStart, bMid - 1, index);
            else return getKth(A, aMid + 1, aEnd, B, bStart, bEnd, index - (aMid - aStart) - 1);
        } else {
            if( index <= leftHalf ) return getKth(A,aStart,aMid-1,B,bStart,bEnd,index);
            else return getKth(A,aStart,aEnd,B,bMid+1,bEnd,index-(bMid-bStart)-1);
        }
    }
}
```