// Set
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

// Sort + Two pointers

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

// Binary Search 
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

