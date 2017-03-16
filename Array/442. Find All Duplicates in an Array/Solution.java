public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for( int i = 0 ; i < nums.length ; i++ ){
            if( !set.contains(nums[i])){
                set.add(nums[i]);
            } else {
                res.add(nums[i]);
            }
        }
        return res;
    }
}