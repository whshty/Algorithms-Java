public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        int start = lower - 1;
        for( int i = 0 ; i <= nums.length ; i++){
            int after;
            if ( i != nums.length){
                after = nums[i];
            } else {
                after = upper + 1;
            }
            if( pre + 2 == after ){
                res.add(String.valueOf(pre + 1 ));
            } 
            if( pre + 2 < after ){
                res.add(String.valueOf(pre+1) + "->" + String.valueOf(after-1));
            }
            pre = after;
        }
        return res;
    }
}