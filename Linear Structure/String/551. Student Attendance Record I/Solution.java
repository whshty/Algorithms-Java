class Solution {
    public boolean checkRecord(String s) {
        if (s.contains("LLL")) return false;
        int absentCount = 0;
        
    	// String str = s.replaceAll("A", "");	
    	// if ((s.length() - str.length()) > 1) return false;
    		
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == 'A') {
                absentCount++;
                if (absentCount > 1 ) return false;
            } 
        }
        return true;
    }
}