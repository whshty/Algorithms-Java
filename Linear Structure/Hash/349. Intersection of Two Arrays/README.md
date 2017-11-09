## 1.Set
```java
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        
        for( int num : nums1){
            set.add(num);
        }
        
        for( int num : nums2 ){
            if( set.contains(num)){ 
                intersection.add(num);
            }
        }
        int[] res = new int[intersection.size()];
        int index = 0;
        for( int i : intersection ){
            res[index++] = i;
        }
        return res;
    }
}
```

## 2.Both Arrays Are Sorted + Two pointers
```java
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (Integer num : set) {
            res[index++] = num;
        }
        return res;
    }
}
```


## 3.Binary Search - Only One Input Array is sorted

```java
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) set.add(num);
        }
        int index = 0;
        int[] res = new int[set.size()];
        
        for (Integer num : set) {
            res[index++] = num;
        }
        return res;
    }
    
    public boolean binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while ( start  <= end ) {
            int mid = ( start + end ) >>> 1;
            if ( nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
```

## 4.Both Arrays Are Sorted : Binary Search In Two Pointers

```java
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        // the size of num1 is much more bigger than nums2 and nums1 is sparse
        // nums1 = [1,1,1,1,1,1,1,2,2,2,3,4,5,6,7,7,7,8,9]
        // nums2 = [6,7]

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i = binarySearch(nums1,nums2[j],i,nums1.length-1);
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (Integer num : set) {
            res[index++] = num;
        }
        return res;
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        while ( start < end ) {
            int mid = ( start + end ) >>> 1;
            if(nums[mid] < target){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}

```
