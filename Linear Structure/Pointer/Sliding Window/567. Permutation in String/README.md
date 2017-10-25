```java
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length() , len2 = s2.length();
        int[] freqOne = new int[26];
        for(int i = 0 ; i < len1 ; i++) {
            freqOne[s1.charAt(i)-'a']++;
        }
        
        int[] freqTwo = new int[26];
        int index = 0;
        while (index < len2){
            freqTwo[s2.charAt(index)-'a']++;
            if( index >= len1 ) freqTwo[s2.charAt(index-len1) - 'a']--;
            if( Arrays.equals(freqTwo,freqOne) ){
                return true;
            }
            index++;
        }
        return false;
    }
}
```