class Solution {
    public String alienOrder(String[] words) {
        Map<Character,Set<Character>> map = new HashMap<>();
        Map<Character,Integer> indegree = new HashMap<>();
        initMapAndIndegree(words, map, indegree);
        return getResult(map,indegree);
    }
    
    private void initMapAndIndegree(String[] words, Map<Character,Set<Character>> map, Map<Character,Integer> indegree) {
        for (String word : words) {
            for (Character ch : word.toCharArray()) {
                indegree.put(ch,0);
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String one = words[i];
            String two = words[i+1];
            int len = Math.min(one.length(), two.length());
            
            for (int j = 0; j < len; j++) {
                char ch1 = one.charAt(j);
                char ch2 = two.charAt(j);
                
                if (ch1 != ch2) {
                    Set<Character> set = map.getOrDefault(ch1,new HashSet<>());
                    if (!set.contains(ch2)) {
                        set.add(ch2);
                        map.put(ch1, set);
                        indegree.put(ch2, indegree.getOrDefault(ch2,0) + 1);
                    }                  
                    break; 
                }
            } 
        }    
    }
    
    private String getResult(Map<Character,Set<Character>> map, Map<Character,Integer> indegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) queue.add(ch);
        }
        
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            sb.append(ch);
            if (map.containsKey(ch)) {
               for (char nextCh : map.get(ch)) {
                    indegree.put(nextCh, indegree.get(nextCh) - 1);
                    if (indegree.get(nextCh) == 0) queue.add(nextCh);
               } 
            }
        }
        
        if (sb.length() != indegree.size()) return "";
        return sb.toString();      
    }
}