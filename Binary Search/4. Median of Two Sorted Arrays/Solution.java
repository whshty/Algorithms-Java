// Recursion 
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

// Iteration
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 > len2) return findMedianSortedArrays(nums2, nums1);

        int start = 0, end = 2 * len1;
        while (start <= end) {
            int mid1 = (start + end) >>> 1;
            int mid2 = len1 + len2 - mid1;

            double left1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double right1 = (mid1 == 2 * len1) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            double left2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double right2 = (mid2 == 2 * len2) ? Integer.MAX_VALUE : nums2[mid2 / 2];

            if (left1 > right2) end = mid1 - 1;
            else if (left2 > right1) start = mid1 + 1;
            else return (Math.max(left1, left2) + Math.min(right1, right2)) / 2;
        }
        return -1;
    }
}