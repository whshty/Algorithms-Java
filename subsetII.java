// O(n log n) 
// Recursion
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

// iteration 
// time (2^n)
// space o(2^n * n )
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0 ) return res;
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());
        // begin : wall to avoid calculate duplicate
        int begin = 0;
        for(int i = 0 ; i < nums.length ; i++ ){
            if( i == 0 || nums[i] != nums[i-1]) begin = 0;
            int size = res.size();
            for(int j = begin ; j < size; j++ ){
                List<Integer> temp = new ArrayList<Integer>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
            begin = size;
        }
        return res;
    }
}