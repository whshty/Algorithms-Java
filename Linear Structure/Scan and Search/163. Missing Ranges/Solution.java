public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int start = lower;
        for(int i : nums) {
            if(i > start ) {
                if( i - 1 > start ) {
                    res.add(start + "->" + (i-1));
                } else{
                    res.add(String.valueOf(start));
                }
            }
            if(i == upper) return res; // Avoid overflow
            start = i+1;
        }
        if( upper > start ){
            res.add(start + "->" + upper);
        } else {
            res.add(String.valueOf(start));
        }
        return res;
    }
}