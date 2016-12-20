/*
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

The subarray sum reminds me the range sum problem. Preprocess the input array such that you get
the range sum in constant time.
sum[i] means the sum from 0 to i inclusively
the sum from i to j is sum[j] - sum[i - 1] except that from 0 to j is sum[j].

j-i is equal to the length of subarray of original array. we want to find the max(j - i)
for any sum[j] we need to find if there is a previous sum[i] such that sum[j] - sum[i] = k
Instead of scanning from 0 to j -1 to find such i, we use hashmap to do the job in constant time.
However, there might be duplicate value of of sum[i] we should avoid overriding its index as we want the max j - i, so we want to keep i as left as possible.

*/
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        for (int i = 1; i < n; i++)
            nums[i] += nums[i - 1];
        Map<Integer, Integer> map = new HashMap<>(); 
        int max = 0;
        // add this fake entry to make sum from 0 to j consistent
        // k is the sum of element from nums[0] to nums[i]
        // the len of subarray is i - 0 + 1. 
        // in other words, (0, -1) is the initial status.        
        map.put(0, -1); 
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i] - k))
                max = Math.max(max, i - map.get(nums[i] - k));
            if (!map.containsKey(nums[i])) // keep only 1st duplicate as we want first index as left as possible
                map.put(nums[i], i);
        }
        return max;
    }
}