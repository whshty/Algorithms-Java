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

## 2.Follow Up (Sorted Input) - Two Pointer

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