class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if( n == 0 ) return res;
        helper(res,new char[n],0,n-1);
        return res;
    }
    public void helper(List<String> res,char[] chs ,int left , int right){
        if( left > right ) {
            if( !res.contains(new String(chs))){
                res.add(new String(chs));     
            }
            return;
        }
        if( left == right ){
            chs[left] = '0';
            res.add(new String(chs));
            chs[left] = '1';
            res.add(new String(chs));
            chs[left] = '8';
            res.add(new String(chs));
            return;
        }
        if( left != 0 ){
            chs[left] = '0';
            chs[right] = '0';
            helper(res,chs,left+1,right-1);
        }
        chs[left] = '1';
        chs[right] = '1';
        helper(res,chs,left+1,right-1);
        
        chs[left] = '8';
        chs[right] = '8';
        helper(res,chs,left+1,right-1);
    
        chs[left] = '6';
        chs[right] = '9';
        helper(res,chs,left+1,right-1);
    
        chs[left] = '9';
        chs[right] = '6';
        helper(res,chs,left+1,right-1);
    }
}