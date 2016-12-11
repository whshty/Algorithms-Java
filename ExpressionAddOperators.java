// backtracking 
// time O(3^n)each time we have three operations
// Space O(n) for stack
// overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
// sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
 // a little trick is that we should save the value that is to be multiplied in the next recursion.

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if(num == null || num.length() == 0) return res;
        helper(res,"",num,target,0,0,0);
        return res;
    }
    private void helper(List<String> res, String path, String num, int target, int pos, long tempRes, long multed){
        if(pos == num.length()){
            if(target == tempRes) res.add(path);
            return;
        }
        for(int i = pos; i < num.length() ; i++ ){
            if( i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos,i+1));
            if(pos == 0){
                helper(res,path+cur,num,target,i+1,cur,cur);
            } else{
                helper(res,path+"+"+cur,num,target,i+1,tempRes+cur,cur);
                helper(res,path+"-"+cur,num,target,i+1,tempRes-cur,-cur);
                helper(res,path+"*"+cur,num,target,i+1,tempRes-multed+multed*cur,multed*cur);
            }
        }
    }
}