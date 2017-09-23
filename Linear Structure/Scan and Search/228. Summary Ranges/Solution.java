class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if( nums.length == 1 ) {
            res.add(nums[0]+"");
            return res;
        }
        
        for( int i = 0 ; i < nums.length ; i++ ){
            int cur = nums[i];
            while( i + 1 < nums.length && nums[i+1]  == 1 + nums[i])  i++;
            if( cur != nums[i]) res.add(cur+"->"+nums[i]);
            else res.add(cur+"");
        }
        return res;
    }
}z