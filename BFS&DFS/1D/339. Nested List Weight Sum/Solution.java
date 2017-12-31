class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList,1);
    }
    public int helper(List<NestedInteger> list, int depth){
        int res = 0;
        for( NestedInteger i : list ){
            res += i.isInteger() ? i.getInteger() * depth : helper(i.getList(),depth + 1);
        }
        return res;
    }
}