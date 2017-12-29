class Solution {
    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        
        int len = Math.max(strs1.length,strs2.length);
        
        for( int i = 0 ; i < len ; i++ ){
            Integer temp1 = i < strs1.length ? Integer.parseInt(strs1[i]) : 0;
            Integer temp2 = i < strs2.length ? Integer.parseInt(strs2[i]) : 0;
            
            int isBigger = temp1.compareTo(temp2);
            if( isBigger != 0 ) return isBigger;
        }
        return 0;
        
    }
}