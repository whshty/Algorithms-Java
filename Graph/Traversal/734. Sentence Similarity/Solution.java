class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        
        Map<String,Set<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            map.computeIfAbsent(pair[0], set -> new HashSet<>()).add(pair[1]);
        }
        
        for (int i = 0; i < words1.length; i++) {
            if(!words1[i].equals(words2[i]) && 
               !map.getOrDefault(words1[i],new HashSet<>()).contains(words2[i]) && 
               !map.getOrDefault(words2[i],new HashSet<>()).contains(words1[i])) {
                return false;
            }
        }
        return true;
    }
}