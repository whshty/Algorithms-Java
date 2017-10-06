class Solution {
    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        int[] left = countXandNumber(parts[0]);
        int[] right = countXandNumber(parts[1]);
        
        if(left[0] == right[0] && left[1] == right[1]) {
            return "Infinite solutions";
        } else if (left[0] == right[0]){
            return "No solution";
        }
        return "x="+ (right[1]-left[1])/(left[0]-right[0]);
    }
    
    public int[] countXandNumber(String s){
         //()for match group; ?= for match and include in res; [+-] means + or -;
        String[] strs = s.split("(?=[+-])"); 
        int[] res = new int[2];
        for( String str : strs ){
            if(str.equals("+x") || str.equals("x")) res[0]++;
            else if(str.equals("-x")) res[0]--;
            else if(str.contains("x")) res[0] += Integer.parseInt(str.substring(0,str.length()-1));
            else res[1] += Integer.parseInt(str);
        }
        return res;
    }
}