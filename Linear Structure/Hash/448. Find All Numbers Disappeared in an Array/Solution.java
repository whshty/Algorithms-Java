class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for ( int num : nums ){
            set.add(num);
        }
        for( int i = 1 ; i <= nums.length; i++){
            if( !set.contains(i)) res.add(i);
        }
        return res;
    }
}

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for ( int i = 0 ; i < nums.length ; i++ ){
            int index = Math.abs(nums[i]) - 1;
            if ( nums[index] > 0 ) nums[index] = -nums[index];
        }
        
        for( int i = 0 ; i < nums.length ; i++ ){
            if( nums[i] > 0 ) res.add(i+1);
        }
        return res;
    }
}