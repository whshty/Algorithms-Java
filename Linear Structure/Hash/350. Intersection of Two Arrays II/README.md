## 1.HashMap

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for( int i : nums1 ){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for( int i : nums2 ){
            if( map.containsKey(i) && map.get(i) > 0 ){
                list.add(i);
                map.put(i,map.get(i)-1);
            }
        }
        int[] res = new int[list.size()];
        for( int i = 0 ; i < list.size(); i++ ){
            res[i] = list.get(i);
        }
        return res;
    }
}
```

## 2.Follow Up (Two Sorted Input) - Two Pointer

```java
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        
        int i = 0 , j = 0;
        while( i < nums1.length && j < nums2.length ){
            if( nums1[i] < nums2[j] ) i++;
            else if( nums1[i] > nums2[j] ) j++;
            else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        for( int index = 0 ; index < list.size(); index++ ){
            res[index] = list.get(index);
        }
        return res;
    }
}
```

## 3.Binary Search 
* Two array are sorted
* A is much longer than B

```java
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
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
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (Integer num : list) {
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