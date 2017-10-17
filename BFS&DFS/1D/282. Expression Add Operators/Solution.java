// + and -
class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        myCode sol = new myCode();
        List<String> res = sol.addOperators("123456789",100);
        for( String s : res){
            System.out.println(s);
        }        
    }
    public List<String> addOperators(String n, int target){
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res,sb,n,0,target,0);
        return res;
        
    }
    public void helper(List<String> res,StringBuilder sb, String n,int pos,int target,long sum){
        if( pos ==  n.length()){
            if( target == sum){
                res.add(sb.toString());
            }
            return;
        }
        for(int i=pos;i<n.length();i++){
            // 0 can only appear as itselft, not as the start of another number 
            if(n.charAt(pos) == '0' && i != pos) break;
            long cur = Long.parseLong (n.substring(pos,i+1));
            int len = sb.length();
            if( pos == 0 ){
                helper(res,sb.append(cur),n,i+1,target,cur);
                sb.setLength(len);
            } else {
                helper(res,sb.append("+").append(cur),n,i+1,target,sum+cur);
                sb.setLength(len);
                helper(res,sb.append("-").append(cur),n,i+1,target,sum-cur);
                sb.setLength(len);
            }
        }
    }
}


// + , - and *
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