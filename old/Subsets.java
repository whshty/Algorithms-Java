// dfs + recrusion
// o(2^n)
// o(n) for recrustion stack
// o(2^n * n ) for result
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

// iteration  bfs
// time 2^n
/*
The idea is:
起始subset集为：[]
添加S0后为：[], [S0]
添加S1后为：[], [S0], [S1], [S0, S1]
添加S2后为：[], [S0], [S1], [S0, S1], [S2], [S0, S2], [S1, S2], [S0, S1, S2]
红色subset为每次新增的。显然规律为添加Si后，新增的subset为克隆现有的所有subset，并在它们后面都加上Si。
*/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        
        for(int i:nums){
            List<List<Integer>> nextRes = new ArrayList<>();
            for(List<Integer> oldList : res){
                List<Integer> newList = new ArrayList(oldList);
                newList.add(i);
                nextRes.add(newList);
            }
            res.addAll(nextRes);
        }
        return res;
    }
}