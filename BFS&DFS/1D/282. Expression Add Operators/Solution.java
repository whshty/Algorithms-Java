public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if(num == null || num.length() == 0) return res;
        helper(res,new StringBuilder(),num,target,0,0,0);
        return res;
    }
    private void helper(List<String> res, StringBuilder sb, String num, int target, int pos, long tempRes, long multed){
        if(pos == num.length()){
            if(target == tempRes) res.add(sb.toString());
            return;
        }
        
        for(int i = pos; i < num.length() ; i++ ){
            int len = sb.length();
            if( i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos,i+1));
            if(pos == 0){
                helper(res,sb.append(cur),num,target,i+1,cur,cur);
                sb.setLength(len);
            } else{
                helper(res,sb.append("+").append(cur),num,target,i+1,tempRes+cur,cur);
                sb.setLength(len);
                helper(res,sb.append("-").append(cur),num,target,i+1,tempRes-cur,-cur);
                sb.setLength(len);
                helper(res,sb.append("*").append(cur),num,target,i+1,tempRes-multed+multed*cur,multed*cur);
                sb.setLength(len);
            }
            
        }
    }
}