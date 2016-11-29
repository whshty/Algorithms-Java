// time o(n^2)
public class Solution {
    public String countAndSay(int n) {
        return count("1",n);
    }
    private String count(String s, int n){
        //corner case
        if(n==1) return s;        
        int count=0;
        String str ="";
        for(int i=0;i<s.length();i++){
            if(i+1<s.length()&&s.charAt(i)==s.charAt(i+1)){
                count++;    
            } else if(i+1<s.length()&&s.charAt(i)!=s.charAt(i+1)){
                count++;
                str+=count+""+s.charAt(i);
                count=0;
            } else {
                count++;
                str += count+""+s.charAt(i);
            }
        }
        return count(str,n-1);
    }
}