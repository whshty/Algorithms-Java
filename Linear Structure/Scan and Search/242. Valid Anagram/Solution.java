public class Solution {
    public boolean isAnagram(String s, String t) {
    	//sorting
    	if (s.length() != t.length()) return false;
    	char[] str1 = s.toCharArray();
    	char[] str2 = t.toCharArray();
    	Arrays.sort(str1);
    	Arrays.sort(str2);
    	return Arrays.equals(str1, str2);
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
    	//sorting
    	if (s.length() != t.length()) return false;
        int[] freq = new int[26]; 
        for (int i = 0 ; i < s.length() ; i++) {
            freq[s.charAt(i)-'a']++;
        }
        
        for (int i = 0 ; i < t.length() ; i++) {
            freq[t.charAt(i)-'a']--;
        }
        for (int i : freq) if (i != 0) return false;
        return true;
    }
}