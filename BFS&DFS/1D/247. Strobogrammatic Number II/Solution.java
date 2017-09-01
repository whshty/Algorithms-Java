class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if( n == 0 ) return res;
        helper(res,new char[n],0,n-1);
        return res;
    }
    public void helper(List<String> res,char[] ch ,int left , int right){
        if( left > right ) {
            if( !res.contains(new String(ch))){
                res.add(new String(ch));     
            }
            return;
        }
        if( left == right ){
            ch[left] = '0';
            res.add(new String(ch));
            ch[left] = '1';
            res.add(new String(ch));
            ch[left] = '8';
            res.add(new String(ch));
            return;
        }
        if( left != 0 ){
            ch[left] = '0';
            ch[right] = '0';
            helper(res,ch,left+1,right-1);
        }
        ch[left] = '1';
        ch[right] = '1';
        helper(res,ch,left+1,right-1);
        
        ch[left] = '8';
        ch[right] = '8';
        helper(res,ch,left+1,right-1);
    
        ch[left] = '6';
        ch[right] = '9';
        helper(res,ch,left+1,right-1);
    
        ch[left] = '9';
        ch[right] = '6';
        helper(res,ch,left+1,right-1);
    }
}