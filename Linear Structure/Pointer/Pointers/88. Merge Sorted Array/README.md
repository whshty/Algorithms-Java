## 1.Two Pointers — Modify Input
```java
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = n + m - 1;
        while ( i >= 0 && j >= 0 ){
            if ( nums1[i] > nums2[j]){
                nums1[index] = nums1[i];
                i--;
                index--;
            } else {
                nums1[index] = nums2[j];
                j--;
                index--;
            }
        }
        // nums1 = [4,5,0,0,0]
        // nums2 = [1,2,3]
        while ( j >= 0 ){
            nums1[index] = nums2[j];
            index--;
            j--;
        }
    }
}
```

## 2.Two Pointers — Generate New Array
```java
public class Solution {
    public int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = m - 1;
        int j = n - 1;
        int index = n + m - 1;
        int[] res = new int[m+n];

        while ( i >= 0 && j >= 0 ){
            if ( nums1[i] > nums2[j]){
                res[index] = nums1[i];
                i--;
                index--;
            } else {
                res[index] = nums2[j];
                j--;
                index--;
            }
        }
        while ( i >= 0 ){
            res[index] = nums1[i];
            index--;
            i--;
        }
        while ( j >= 0 ){
            res[index] = nums2[j];
            index--;
            j--;
        }
        return res;
    }
}
```

