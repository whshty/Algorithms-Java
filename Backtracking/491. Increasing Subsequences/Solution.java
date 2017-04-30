public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        
        helper(res,list,0,nums);
        List finalRes = new ArrayList(res);
        return finalRes;
        
    }
    
    public void helper(Set<List<Integer>> res, List<Integer> list, int index, int[] nums){
        if( list.size() >= 2 ){
            res.add(new ArrayList(list));
        }
        for( int i = index ; i < nums.length ; i++){
            if( list.size() == 0 || list.get(list.size() -1 ) <= nums[i]){
                list.add(nums[i]);
                helper(res,list,i+1,nums);
                list.remove(list.size()-1);
            }
        }
    }
}