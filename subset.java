/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
// time : o(2^n)
// space : o(n) for stack, o(2^n*n) for result
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0) return res;
        helper(res,new ArrayList<>(),nums,0);
        return res;
    }
    private void helper(List<List<Integer>> res,List<Integer> list, int[] nums, int pos){
        res.add(new ArrayList<Integer>(list));
        for(int i=pos;i<nums.length;i++){
            list.add(nums[i]);
            helper(res,list,nums,i+1);
            list.remove(list.size() -1);
        }
    }
}
/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(res,new ArrayList<>(),nums,0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int pos){
        res.add(new ArrayList<>(list));
        for(int i = pos; i < nums.length ; i++){
            //skip duplicate
            if(i > pos && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            helper(res,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
