public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s.toCharArray(),res,0,new StringBuilder(),0);
        return res;
    }
    public void helper(char[] arr , List<String> res , int pos , StringBuilder sb, int count){
        if( count > 4 ) return;
        if( count == 4 && pos == arr.length ){
            res.add(sb.toString());
            return;
        }
        
        int num = 0, len = sb.length();
        for( int i = pos ; i <= pos + 3 && i < arr.length ; i++ ){
            num = num * 10 + arr[i] - '0';
            if( num >= 256 ) break;
            sb.append(num);
            if( count != 3 ){
                sb.append('.');
            }
            helper(arr,res,i+1,sb,count+1);
            sb.setLength(len);
            if(num == 0) break;
        }
    }
}