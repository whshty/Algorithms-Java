// two hashsets 
// time o(n)
// space one pass 
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        for( int i = 0 ; i < nums1.length; i++ ){
            set.add(nums1[i]);
        }
        for( int i = 0 ; i < nums2.length ; i++ ){
            if( set.contains(nums2[i]) ){
                res.add(nums2[i]);
            }
        }
        int[] finalRes = new int[res.size()];
        int i = 0;
        for( Integer num : res){
            
            finalRes[i++] = num;
        }
        return finalRes;
    }
}

// sort both arrays, two points
// time : O(nlogn)
// space O(n)
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while( i < nums1.length && j < nums2.length ){
            if( nums1[i] > nums2[j]){
                j++;
            } else if (nums1[i] < nums2[j]){
                i++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[set.size()];
        int k = 0;
        for( Integer num : set ){
            res[k++] = num;
        }
        return res;
    }
}
// Binary search
// Time complexity: O(nlogn)
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<Integer>();
        for(Integer num : nums1){
            if(binarySearch(nums2,num)) set.add(num);
        }
        int j = 0;
        int[] res = new int[set.size()];
        for(Integer num: set ){
            res[j++] = num;
        }
        return res;
    }
    private boolean binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while( start <= end ){
            int mid = start + ( end - start ) / 2;
            if( nums[mid] == target ) return true;
            if( nums[mid] > target ) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}